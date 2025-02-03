import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

function FundingOpportunities() {
    const [opportunities, setOpportunities] = useState([]);

    useEffect(() => {
        const fetchOpportunities = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/funding-opportunities');
                setOpportunities(response.data);
            } catch (error) {
                console.error('Failed to fetch opportunities', error);
            }
        };

        fetchOpportunities();
    }, []);

    return (
        <div className="container mt-5">
            <h2>Funding Opportunities</h2>
            <ul>
                {opportunities.map(opportunity => (
                    <li key={opportunity.id}>
                        <a href={`/apply/${opportunity.id}`}>{opportunity.title}</a> - {opportunity.description} (Click the link to start an Application)
                    </li>
                ))}
            </ul>
            {/* Content Section */}
                
            <Link to="/dashboard" className="btn btn-success">Go to Dashboard</Link>
        </div>
    );
}

export default FundingOpportunities;