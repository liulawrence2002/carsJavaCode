import React from 'react';
import WorkflowManagement from './WorkflowManagement'; // Use the renamed component

function WorkflowManagementPage() {
  return (
    <div style={{ height: '100vh' }}>
      <h1 style={{ padding: '20px', background: '#f9f9f9', borderBottom: '1px solid #ccc' }}>
        Workflow Management
      </h1>
      <WorkflowManagement />
    </div>
  );
}

export default WorkflowManagementPage;