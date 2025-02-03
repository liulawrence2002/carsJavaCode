import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import logo from './images/cprit-logo.png';

function Header({ isLoggedIn, username, onLogout }) {
    const navigate = useNavigate(); // Use the useNavigate hook

    // Handle logout
    const handleLogout = () => {
        onLogout(); // Call the logout function passed from App.js
        navigate('/'); // Redirect to the home page
    };

    return (
        <header className="bg-dark text-white p-3">
            <div className="container">
                <div className="row align-items-center">
                    {/* Left Half: Logo and Title */}
                    <div className="col-md-6 d-flex align-items-center">
                        <img
                            src={logo} // Replace with the actual path to your logo
                            className="img-fluid me-3"
                            style={{ width: '50vw', minWidth: '340px', maxWidth: '565px', maxheight: '100px' }}
                        />
                    </div>

                    {/* Right Half: Top and Bottom Sections */}
                    <div className="col-md-6">
                        {/* Top Half: Search Box, Welcome Message, and Login/Logout Button */}
                        <div className="d-flex flex-column flex-md-row justify-content-between align-items-center mb-3">
                            {/* Search Box */}
                            <div className="input-group me-md-3 mb-2 mb-md-0">
                                <input
                                    type="text"
                                    placeholder="Search"
                                    className="form-control form-control-sm"
                                />
                                <button className="btn btn-outline-light btn-sm" type="button">
                                    <i className="fas fa-search"></i>
                                </button>
                            </div>

                            {/* Welcome Message and Login/Logout Button */}
                            <div className="d-flex align-items-center gap-2">
                                {isLoggedIn ? (
                                    <>
                                        <span className="text-white">Welcome, {username}</span>
                                        <button className="btn btn-danger btn-sm" onClick={handleLogout}>
                                            Log Out
                                        </button>
                                    </>
                                ) : (
                                    <Link to="/login" className="btn btn-primary btn-sm">
                                        Log In
                                    </Link>
                                )}
                            </div>
                        </div>

                        {/* Bottom Half: Navigation Links */}
                        <nav className="d-flex justify-content-center justify-content-md-end gap-3">
                            <Link to="/" className="text-white text-decoration-none">Home</Link>
                            <Link to="/funding-opportunities" className="text-white text-decoration-none">Funding Opportunities</Link>
                            <Link to="/dashboard" className="text-white text-decoration-none">Dashboard</Link>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
    );
}

export default Header;