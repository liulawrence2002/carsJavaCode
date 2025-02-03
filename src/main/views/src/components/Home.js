import React from 'react';
import { Link } from 'react-router-dom';

function Home() {
    return (
        <div>
            {/* Hero Section */}
            <div className="bg-primary text-white text-center py-5">
                <h1>Welcome to the Grant Application Portal</h1>
                <p>Explore funding opportunities and manage your applications.</p>
                <Link to="/funding-opportunities" className="btn btn-light btn-lg me-1">View Funding Opportunities</Link>   
                <Link to="/news-announcements" className="btn btn-light btn-lg">News and Announcements</Link>
            </div>

            {/* Programs Section */}
            <div className="py-5" style={{ backgroundColor: '#a4bbc1' }}> {/* Your custom color */}
                <div className="container">
                    <div className="row mb-4">
                        <div className="col d-flex justify-content-between align-items-center">
                            <h2>Our Programs</h2>
                            <Link to="/programs" className="btn btn-outline-primary">Learn More</Link>
                        </div>
                    </div>

                    <div className="row">
                        <div className="col-md-4 mb-4 d-flex">
                            <div className="bg-white p-4 rounded shadow-sm w-100">
                                <h3>Academic Research</h3>
                                <p className="text-muted">
                                    CPRIT supports the most creative ideas and meritorious projects brought forward by the 
                                    cancer research community in Texas.
                                </p>
                                <Link to="/programs/academic-research" className="btn btn-link">Learn More</Link>
                            </div>
                        </div>

                        <div className="col-md-4 mb-4 d-flex">
                            <div className="bg-white p-4 rounded shadow-sm w-100">
                                <h3>Prevention</h3>
                                <p className="text-muted">
                                    Ten percent of CPRIT funds support the delivery of evidence-based cancer prevention 
                                    interventions to underserved populations in Texas.
                                </p>
                                <Link to="/programs/prevention" className="btn btn-link">Learn More</Link>
                            </div>
                        </div>

                        <div className="col-md-4 mb-4 d-flex">
                            <div className="bg-white p-4 rounded shadow-sm w-100">
                                <h3>Product Development Research</h3>
                                <p className="text-muted">
                                    CPRIT creates and supports infrastructure in Texas that accelerates the movement of 
                                    new cancer drugs, diagnostics, and therapies from the laboratory to the patient.
                                </p>
                                <Link to="/programs/product-development" className="btn btn-link">Learn More</Link>
                            </div>
                        </div>
                    </div>

                    <div className="row mt-4">
                        <div className="col">
                            <div className="bg-white p-4 rounded shadow-sm">
                                <p className="text-muted mb-0">
                                    Set by the CPRIT Oversight Committee, the Program Priorities guide the direction 
                                    of the agency's funding portfolio.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    );
}

export default Home;