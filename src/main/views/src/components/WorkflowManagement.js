import React, { useState, useRef } from "react";
import { DndProvider, useDrag, useDrop } from "react-dnd";
import { HTML5Backend } from "react-dnd-html5-backend";

// Node types that can be dragged
const NODE_TYPES = [
  { id: "1", type: "Complete Web Form" },
  { id: "2", type: "ASO Review" },
  { id: "3", type: "Add Additional Reviewer" },
  { id: "4", type: "CM Review" },
  { id: "5", type: "EO Approval" },
  { id: "6", type: "EO Review" },
  { id: "7", type: "Financial Officer Review" },
  { id: "8", type: "Grant Manager Review" },
  { id: "9", type: "Grant Manager Recommendation" },
  { id: "10", type: "Post-Award Manager Evaluation" },
  { id: "11", type: "Program Officer Evaluation" },
  { id: "12", type: "Program Officer Recommendation" },
];

// Connection types and their styles
const CONNECTION_TYPES = {
  Submit: { stroke: "blue", strokeDasharray: null },
  Review: { stroke: "green", strokeDasharray: "5,5" },
  Approve: { stroke: "purple", strokeDasharray: null },
  Disapproval: { stroke: "red", strokeDasharray: "10,5" },
};

// Draggable Node Component for the Left Pane
const DraggableNode = ({ id, type }) => {
  const [{ isDragging }, drag] = useDrag(() => ({
    type: "node",
    item: { id, type },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  }));

  return (
    <div
      ref={drag}
      style={{
        opacity: isDragging ? 0.5 : 1,
        padding: "10px",
        margin: "5px",
        border: "1px solid #ccc",
        backgroundColor: "#f9f9f9",
        cursor: "move",
      }}
    >
      {type}
    </div>
  );
};

// Node Component for the Workspace
const WorkspaceNode = ({ id, type, position, onDelete, onClick, isSelected }) => {
  const [{ isDragging }, drag] = useDrag(() => ({
    type: "workspaceNode",
    item: { id, type, position },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  }));

  return (
    <div
      ref={drag}
      style={{
        padding: "10px",
        margin: "5px",
        border: `2px solid ${isSelected ? "blue" : "#ccc"}`,
        backgroundColor: "#f9f9f9",
        cursor: "move",
        position: "absolute",
        left: position?.x || 0,
        top: position?.y || 0,
        opacity: isDragging ? 0.5 : 1,
      }}
      onClick={() => onClick(id)}
    >
      {type}
      <button onClick={() => onDelete(id)} style={{ marginLeft: "10px" }}>
        Delete
      </button>
    </div>
  );
};

// Connection Line Component
const ConnectionLine = ({ connection, fromNode, toNode, onMove, index, onDeleteConnection }) => {
  const [{ isDragging }, drag] = useDrag(() => ({
    type: "connectionLine",
    item: { id: connection.id, index },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  }));

  // Log when the connection is being dragged
  React.useEffect(() => {
    if (isDragging) {
      console.log("Connection is being dragged:", connection);
    }
  }, [isDragging, connection]);

  // Calculate midpoint of the line
  const midX = (fromNode.position.x + toNode.position.x) / 2 + 50; // Adjust for node center
  const midY = (fromNode.position.y + toNode.position.y) / 2 + 20 + (connection.offsetY || 0); // Adjust for node center and offset

  // Calculate the angle of the line for arrowhead orientation
  const angle =
    Math.atan2(
      toNode.position.y - fromNode.position.y,
      toNode.position.x - fromNode.position.x
    ) *
    (180 / Math.PI);

  // Calculate the position of the delete button next to the arrow
  const buttonOffsetX = 20; // Horizontal offset from the arrow
  const buttonOffsetY = 20; // Vertical offset from the arrow
  const buttonX = midX + buttonOffsetX * Math.cos((angle * Math.PI) / 180);
  const buttonY = midY + buttonOffsetY * Math.sin((angle * Math.PI) / 180);

  // Get the connection style based on the connection type
  const connectionStyle = CONNECTION_TYPES[connection.type] || CONNECTION_TYPES.Submit;

  return (
    <React.Fragment>
      {/* Line from the first node to the second node */}
      <line
        ref={drag}
        x1={fromNode.position.x + 50} // Adjust for node center
        y1={fromNode.position.y + 20 + (connection.offsetY || 0)} // Adjust for node center and offset
        x2={toNode.position.x + 50} // Adjust for node center
        y2={toNode.position.y + 20 + (connection.offsetY || 0)} // Adjust for node center and offset
        stroke={connectionStyle.stroke}
        strokeWidth="2"
        strokeDasharray={connectionStyle.strokeDasharray}
        style={{ cursor: "move", opacity: isDragging ? 0.5 : 1 }}
      />
      {/* Arrowhead at the midpoint */}
      <polygon
        points="-10,-10 0,0 -10,10" // Double the size of the arrowhead
        transform={`translate(${midX},${midY}) rotate(${angle})`}
        fill={connectionStyle.stroke}
      />
      {/* Delete button */}
      <foreignObject
        x={buttonX - 10} // Position the delete button next to the arrow
        y={buttonY - 10}
        width="20"
        height="20"
        style={{ pointerEvents: "all" }} // Allow interaction with the button
      >
        <button
          onClick={() => onDeleteConnection(connection.id)}
          style={{
            padding: "5px",
            backgroundColor: "red",
            color: "white",
            border: "none",
            borderRadius: "50%",
            cursor: "pointer",
            fontSize: "12px",
          }}
        >
          X
        </button>
      </foreignObject>
    </React.Fragment>
  );
};

// Workspace Component
const Workspace = ({ nodes, connections, onDrop, onDelete, onConnect, onMoveConnection, onDeleteConnection }) => {
  const workspaceRef = useRef(null);

  const [, drop] = useDrop(() => ({
    accept: ["node", "workspaceNode", "connectionLine"],
    drop: (item, monitor) => {
      const offset = monitor.getClientOffset();
      if (offset && workspaceRef.current) {
        const workspaceRect = workspaceRef.current.getBoundingClientRect();
        const relativeOffset = {
          x: offset.x - workspaceRect.left,
          y: offset.y - workspaceRect.top,
        };
        if (item.type === "connectionLine") {
          onMoveConnection(item.index, relativeOffset.y);
        } else {
          onDrop(item, relativeOffset);
        }
      }
    },
  }));

  return (
    <div
      ref={(node) => {
        drop(node);
        workspaceRef.current = node;
      }}
      style={{
        flex: 1,
        border: "1px dashed #ccc",
        padding: "10px",
        marginLeft: "20px",
        minHeight: "300px",
        position: "relative",
      }}
    >
      {/* Render connection lines with arrowheads */}
      <svg
        style={{
          position: "absolute",
          top: 0,
          left: 0,
          width: "100%",
          height: "100%",
          pointerEvents: "all", // Allow interaction with SVG elements
        }}
      >
        {connections.map((connection, index) => {
          const fromNode = nodes.find((node) => node.id === connection.from);
          const toNode = nodes.find((node) => node.id === connection.to);

          if (!fromNode || !toNode) return null;

          return (
            <ConnectionLine
              key={connection.id}
              connection={connection}
              fromNode={fromNode}
              toNode={toNode}
              onMove={onMoveConnection}
              index={index}
              onDeleteConnection={onDeleteConnection}
            />
          );
        })}
      </svg>

      {/* Render nodes */}
      {nodes.map((node) => (
        <WorkspaceNode
          key={node.id}
          id={node.id}
          type={node.type}
          position={node.position}
          onDelete={onDelete}
          onClick={onConnect}
          isSelected={node.isSelected}
        />
      ))}
    </div>
  );
};

// Main Workflow Management Component
const WorkflowManagement = () => {
  const [workspaceNodes, setWorkspaceNodes] = useState([]);
  const [connections, setConnections] = useState([]);
  const [selectedNode, setSelectedNode] = useState(null);
  const [isConnectionMode, setIsConnectionMode] = useState(false);
  const [connectionType, setConnectionType] = useState("Submit"); // Default connection type

  const handleDrop = (item, offset) => {
    setWorkspaceNodes((prevNodes) => {
      // Check if the node already exists
      const existingNode = prevNodes.find((node) => node.id === item.id);

      if (existingNode) {
        // Move existing node
        return prevNodes.map((node) =>
          node.id === item.id ? { ...node, position: offset } : node
        );
      } else {
        // Add new node
        const newId = `${item.type}-${Date.now()}`;
        const newNode = {
          id: newId,
          type: item.type,
          position: offset,
          isSelected: false,
        };
        return [...prevNodes, newNode];
      }
    });
  };

  const handleDelete = (id) => {
    setWorkspaceNodes((prevNodes) => prevNodes.filter((node) => node.id !== id));
    setConnections((prevConnections) =>
      prevConnections.filter(
        (connection) => connection.from !== id && connection.to !== id
      )
    );
  };

  const handleConnect = (nodeId) => {
    if (!isConnectionMode) return; // Only allow connections in connection mode

    console.log("Node selected for connection:", nodeId); // Log the selected node

    if (selectedNode) {
      // Check if a connection already exists between the selected node and the clicked node in the same direction
      const existingConnection = connections.find(
        (connection) =>
          connection.from === selectedNode && connection.to === nodeId
      );

      if (existingConnection) {
        alert("A connection already exists in this direction.");
        return; // Prevent adding duplicate connections in the same direction
      }

      // Calculate the offsetY based on the number of existing connections between the two nodes
      const existingConnections = connections.filter(
        (connection) =>
          (connection.from === selectedNode && connection.to === nodeId) ||
          (connection.from === nodeId && connection.to === selectedNode)
      );

      const offsetY = existingConnections.length * 20; // Increment offsetY for each new connection

      // Create a connection between the selected node and the clicked node
      setConnections((prevConnections) => [
        ...prevConnections,
        {
          id: `${selectedNode}-${nodeId}-${Date.now()}`,
          from: selectedNode,
          to: nodeId,
          offsetY,
          type: connectionType, // Add the connection type
        },
      ]);
      console.log("Connection created:", { from: selectedNode, to: nodeId, offsetY, type: connectionType }); // Log the created connection
      setSelectedNode(null); // Reset selected node
      setIsConnectionMode(false); // Exit connection mode
    } else {
      // Set the clicked node as the selected node
      setSelectedNode(nodeId);
      setWorkspaceNodes((prevNodes) =>
        prevNodes.map((node) =>
          node.id === nodeId ? { ...node, isSelected: true } : node
        )
      );
    }
  };

  const handleMoveConnection = (index, offsetY) => {
    console.log("Connection moved:", { index, offsetY }); // Log the moved connection
    setConnections((prevConnections) =>
      prevConnections.map((connection, i) =>
        i === index ? { ...connection, offsetY } : connection
      )
    );
  };

  const handleDeleteConnection = (connectionId) => {
    console.log("Deleting connection:", connectionId); // Log the deleted connection
    setConnections((prevConnections) =>
      prevConnections.filter((connection) => connection.id !== connectionId)
    );
  };

  return (
    <DndProvider backend={HTML5Backend}>
      <div
        style={{
          display: "flex",
          height: "100vh",
          padding: "20px",
          boxSizing: "border-box",
        }}
      >
        {/* Left Pane - Node List */}
        <div
          style={{
            width: "200px",
            borderRight: "1px solid #ccc",
            paddingRight: "20px",
            height: "100%",
          }}
        >
          <h3>Nodes</h3>
          {NODE_TYPES.map((node) => (
            <DraggableNode key={node.id} id={node.id} type={node.type} />
          ))}
        </div>

        {/* Right Pane - Workspace */}
        <div style={{ flex: 1, display: "flex", flexDirection: "column" }}>
          <div style={{ marginBottom: "10px" }}>
            <button
              onClick={() => setIsConnectionMode(!isConnectionMode)}
              style={{
                padding: "10px",
                backgroundColor: isConnectionMode ? "blue" : "#f9f9f9",
                color: isConnectionMode ? "white" : "black",
                border: "1px solid #ccc",
                cursor: "pointer",
              }}
            >
              {isConnectionMode ? "Exit Connection Mode" : "Enter Connection Mode"}
            </button>
            <select
              value={connectionType}
              onChange={(e) => setConnectionType(e.target.value)}
              style={{ marginLeft: "10px", padding: "5px" }}
            >
              <option value="Submit">Submit</option>
              <option value="Review">Review</option>
              <option value="Approve">Approve</option>
              <option value="Disapproval">Disapproval</option>
            </select>
          </div>
          <Workspace
            nodes={workspaceNodes}
            connections={connections}
            onDrop={handleDrop}
            onDelete={handleDelete}
            onConnect={handleConnect}
            onMoveConnection={handleMoveConnection}
            onDeleteConnection={handleDeleteConnection}
          />
        </div>
      </div>
    </DndProvider>
  );
};

export default WorkflowManagement;