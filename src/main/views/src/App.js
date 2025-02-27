import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import Login from './components/Login';
import FundingOpportunities from './components/FundingOpportunities';
import GrantApplicationForm from './components/GrantApplicationForm';
import Dashboard from './components/Dashboard';
import ViewProposal from './components/ViewProposal';
import NewsAndAnnouncements from './components/NewsAndAnnouncements';
import MyApplications from './components/MyApplications';
import WorkflowManagementPage from './components/WorkflowManagementPage'; // Import the new page
import { jwtDecode } from 'jwt-decode'; // Import jwtDecode

function App() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [username, setUsername] = useState('');

    // Check if the user is logged in on initial render
    useEffect(() => {
        const token = localStorage.getItem('token');
        if (token) {
            setIsLoggedIn(true);
            try {
                const decodedToken = jwtDecode(token);
                setUsername(decodedToken.sub); // Set the username from the token
            } catch (error) {
                console.error('Failed to decode token:', error);
            }
        }
    }, []);

    // Function to handle login
    const handleLogin = (token) => {
        localStorage.setItem('token', token);
        const decodedToken = jwtDecode(token);
        setUsername(decodedToken.username);
        setIsLoggedIn(true);
    };

    // Function to handle logout
    const handleLogout = () => {
        localStorage.removeItem('token');
        setUsername('');
        setIsLoggedIn(false);
    };

    return (
        <Router>
            <Header isLoggedIn={isLoggedIn} username={username} onLogout={handleLogout} />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login onLogin={handleLogin} />} />
                <Route path="/funding-opportunities" element={<FundingOpportunities />} />
                <Route path="/apply/:id" element={<GrantApplicationForm />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/view-proposal/:id" element={<ViewProposal />} />
                <Route path="/news-announcements" element={<NewsAndAnnouncements />} />
                <Route path="/my-applications" element={<MyApplications />} />
                <Route path="/workflow-management" element={<WorkflowManagementPage />} /> {/* New route */}
            </Routes>
            <Footer />
        </Router>
    );
}

export default App;