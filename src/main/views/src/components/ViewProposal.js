import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

function ViewProposal() {
    const { id } = useParams();
    const [proposal, setProposal] = useState(null);

    useEffect(() => {
        const fetchProposal = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/grant-applications/${id}`);
                setProposal(response.data);
            } catch (error) {
                console.error('Failed to fetch proposal', error);
            }
        };

        fetchProposal();
    }, [id]);

    if (!proposal) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container mt-5">
            <h1>{proposal.projectTitle}</h1>
            <p><strong>Project Type:</strong> {proposal.projectType}</p>
            <p><strong>Status:</strong> {proposal.status}</p>
        </div>
    );
}

export default ViewProposal;