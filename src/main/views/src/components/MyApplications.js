import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function MyApplications() {
    const [applications, setApplications] = useState([]);
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        // Check if the user is logged in by verifying the presence of the token in localStorage
        const token = localStorage.getItem("token");
        if (!token) {
            // If no token found, redirect to the login page
            navigate('/login');
        } else {
            // If token exists, set the logged-in state to true
            setIsLoggedIn(true);
            fetchApplications();
        }
    }, [navigate]);

    // Fetch the applications for the logged-in user
    const fetchApplications = async () => {
        try {
            const userId = localStorage.getItem("carsuserid"); // Get the logged-in user's ID
            const response = await axios.get(`http://localhost:8080/api/grant-applications/user/${userId}`);
            console.log("Response data:", response.data); // Log the response data

            // Ensure response.data is an array
            if (Array.isArray(response.data)) {
                setApplications(response.data); // Update the state
            } else {
                console.error("Expected an array but got:", response.data);
            }
        } catch (error) {
            console.error('Failed to fetch applications', error);
        }
    };

    // Log the updated applications state
    useEffect(() => {
        console.log("Updated applications state:", applications);
    }, [applications]); // This effect runs whenever `applications` changes

    // Render the component only if the user is logged in
    if (!isLoggedIn) {
        return null; // or a loading spinner, or an empty div to prevent rendering
    }

    return (
        <div className="container mt-5" style={{ backgroundColor: '#a4bbc1' }}>
            <h1>My Applications</h1>
            {applications.length > 0 ? (
                <table className="table table-bordered">
                    <thead>
                        <tr>
                            <th>Application Number</th>
                            <th>Project Title</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        {applications.map((application) => (
                            <tr key={application.id}>
                                <td>{application.proposalId}</td>
                                <td>{application.projectTitle}</td>
                                <td>{application.status}</td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            ) : (
                <p>No applications found.</p>
            )}
        </div>
    );
}

export default MyApplications;