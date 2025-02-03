import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

function Login({ onLogin }) {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleLogin = async (e) => {
        e.preventDefault();
        setError('');

        try {
            const response = await axios.post('http://localhost:8080/api/auth/login', { username, password });

            if (response.data.token) {
                onLogin(response.data.token); // Call the onLogin function passed from App.js
                localStorage.setItem('carsuserid', response.data.carsuserid);
                navigate('/dashboard');
            } else {
                setError(response.data.message || 'Login failed');
            }
        } catch (error) {
            if (error.response) {
                setError(error.response.data.message || 'Login failed');
            } else if (error.request) {
                setError('Unable to connect to the server. Please try again later.');
            } else {
                setError('An unexpected error occurred. Please try again.');
            }
            console.error('Login failed', error);
        }
    };

    return (
        <div className="container mt-5">
            <form onSubmit={handleLogin} className="card p-4">
                <h2 className="text-center mb-4">Login</h2>
                {error && <div className="alert alert-danger">{error}</div>}
                <div className="form-group  mb-2 me-2">
                    <input
                        type="text"
                        className="form-control"
                        placeholder="Username"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div className="form-group mb-2 me-2">
                    <input
                        type="password"
                        className="form-control"
                        placeholder="Password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" className="btn btn-primary w-100 mb-2 me-2">Login</button>
            </form>
        </div>
    );
}

export default Login;