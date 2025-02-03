import React from 'react';

function Footer() {
    return (
        <footer className="bg-dark text-white p-5 mt-5">
            <div className="container">
                <div className="row">
                    <div className="col-md-4">
                        <h5>Quick Links</h5>
                        <ul className="list-unstyled">
                            <li><a href="/" className="text-white">Home</a></li>
                            <li><a href="/funding-opportunities" className="text-white">Funding Opportunities</a></li>
                            <li><a href="/dashboard" className="text-white">Dashboard</a></li>
                        </ul>
                    </div>
                    <div className="col-md-4">
                        <h5>Contact Us</h5>
                        <p>Email: support@grantapp.com</p>
                        <p>Phone: +1 123-456-7890</p>
                    </div>
                    <div className="col-md-4">
                        <h5>Follow Us</h5>
                        <a href="#" className="text-white mx-2"><i className="fab fa-facebook"></i></a>
                        <a href="#" className="text-white mx-2"><i className="fab fa-twitter"></i></a>
                        <a href="#" className="text-white mx-2"><i className="fab fa-linkedin"></i></a>
                    </div>
                </div>
                <div className="text-center mt-4">
                    <p>&copy; 2025 Grant Application. All rights reserved.</p>
                </div>
            </div>
        </footer>
    );
}

export default Footer;