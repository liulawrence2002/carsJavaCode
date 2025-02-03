import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link, useNavigate } from 'react-router-dom';

function Dashboard() {
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
            //fetchApplications();
        }
    }, [navigate]);

    // Fetch the applications only if the user is logged in
/*    const fetchApplications = async () => {
        try {
            const userId = localStorage.getItem("carsuserid"); // Get the logged-in user's ID
            const response = await axios.get(`http://localhost:8080/api/grant-applications/user/${userId}`);
            setApplications(response.data);
        } catch (error) {
            console.error('Failed to fetch applications', error);
        }
    };
*/
    // Render the dashboard only if the user is logged in
    if (!isLoggedIn) {
        return null; // or a loading spinner, or an empty div to prevent rendering
    }

    return (
        <div className="container mt-5" style={{ backgroundColor: '#a4bbc1' }}>
            <h1>Dashboard</h1>
            <div className="row">
                {/* My Profile Card */}
                <div className="col-md-4 mb-4 d-flex">
                    <Link to="/my-profile" className="w-100 text-decoration-none">
                        <div className="bg-white p-4 rounded shadow-sm h-100">
                            <h3>My Profile</h3>
                            <p className="text-muted">
                                View or edit your personal information, resumes, and/or your organization.
                            </p>
                            <div className="text-primary">Go to My Profile →</div>
                        </div>
                    </Link>
                </div>

                {/* My Applications Card */}
                <div className="col-md-4 mb-4 d-flex">
                    <Link to="/my-applications" className="w-100 text-decoration-none">
                        <div className="bg-white p-4 rounded shadow-sm h-100">
                            <h3>My Applications</h3>
                            <p className="text-muted">
                                View or edit your current applications and past applications.
                            </p>
                            <div className="text-primary">Go to My Applications →</div>
                        </div>
                    </Link>
                </div>

                {/* My Grants Card */}
                <div className="col-md-4 mb-4 d-flex">
                    <Link to="/my-grants" className="w-100 text-decoration-none">
                        <div className="bg-white p-4 rounded shadow-sm h-100">
                            <h3>My Grants</h3>
                            <p className="text-muted">
                                View or edit your funded applications and complete required grant workflow forms or documents.
                            </p>
                            <div className="text-primary">Go to My Grants →</div>
                        </div>
                    </Link>
                </div>
            </div>
        </div>
    );
}

export default Dashboard;
