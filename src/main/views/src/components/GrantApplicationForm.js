import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';

function GrantApplicationForm() {
    const { id,program,fy } = useParams();
    const [step, setStep] = useState(1);
    //const [userId, setUserId] = useState('');
    const [projectTitle, setProjectTitle] = useState('');
    const [projectType, setProjectType] = useState('');
	const [proposalId, setProposalId] = useState('');
    const [countApps, setCountApps] = useState(0);
    const [contactInfo, setContactInfo] = useState('');
    const [projectDetails, setProjectDetails] = useState('');
    const [supportDocuments, setSupportDocuments] = useState(null);
    const [personnelCost, setPersonnelCost] = useState(0);
    const [fringeBenefit, setFringeBenefit] = useState(0);
    const [equipmentCost, setEquipmentCost] = useState(0);
    const [indirectCost, setIndirectCost] = useState(0);
    const [applicationId, setApplicationId] = useState(null); // State to store the ID from Step 1

    const [grantApplication, setGrantApplication] = useState(null);
    const [fundingOpportunity, setFundingOpportunity] = useState(null);
	const [fundingOpportunityLoaded, setFundingOpportunityLoaded] = useState(false);

    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // State to store validation errors
    const [validationErrors, setValidationErrors] = useState({});

    const navigate = useNavigate();

    // Compute applicationNumber dynamically
    const applicationNumber = applicationId && fundingOpportunity
        ? fundingOpportunity.program === 'Research'
            ? `RP${((fundingOpportunity.fy - 2000) * 10000 + countApps).toString()}`
            : fundingOpportunity.program === 'Recruitment'
            ? `RR${((fundingOpportunity.fy - 2000) * 10000 + countApps).toString()}`
            : `PD${((fundingOpportunity.fy - 2000) * 10000 + countApps).toString()}`
        : null;

    // Check if the user is logged in
    useEffect(() => {
        const token = localStorage.getItem('token'); // Check for the token in localStorage
        if (!token) {
            // If no token found, redirect to the login page
            navigate('/login');
        }
    }, [navigate]);

    const handleNext = async () => {
        try {
            // Call handleSubmit and wait for it to complete
            const isSubmissionSuccessful = await handleSubmit();

            // Only proceed to the next step if there are no validation errors
            if (isSubmissionSuccessful && step < 5) {
                setStep(step + 1);
            }
        } catch (error) {
            console.error('Error submitting application:', error);
        }
    };

    const handleBack = () => {
        setStep(step - 1);
    };

    const handleSubmit = async (e) => {
        if (e) {
            e.preventDefault();
        }
        try {
            let url;
            let method; // Declare method without a default value
            let data = {
                userId:localStorage.getItem('carsuserid'),
				proposalId, // Add proposalId here
                projectTitle,
                projectType,
                contactInfo,
                projectDetails,
                supportDocuments,
                personnelCost,
                fringeBenefit,
                equipmentCost,
                indirectCost,
            };

            if (step === 1) {
                url = `http://localhost:8080/api/grant-applications/createGrantApplication`;
                method = 'post'; // Use POST for Step 1
            } else {
                if (!applicationId) {
                    throw new Error('Application ID is missing');
                }
                url = `http://localhost:8080/api/grant-applications/updateGrantApplication/${applicationId}`;
                method = 'put'; // Use PUT for Steps 2–5
            }

            console.log('Submitting data:', data); // Log the data being sent
            console.log('Using method:', method); // Log the HTTP method

            const response = await axios({
                method: method,
                url: url,
                data: data,
            });

            console.log('Application data submitted at step', step, response.data);

            // Save the ID returned from Step 1
            if (step === 1 && response.data.id) {
                setApplicationId(response.data.id);
            }

            // Clear validation errors on successful submission
            setValidationErrors({});
            return true;
        } catch (error) {
            if (error.response && error.response.status === 400) {
                // Capture validation errors from the backend
                setValidationErrors(error.response.data);
            } else {
                console.error('Failed to submit application', error);
            }
            return false;
        }
    };

    useEffect(() => {
        // Fetch the FundingOpportunity object from the backend
        const fetchFundingOpportunity = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/funding-opportunities/${id}`);
                setFundingOpportunity(response.data);
				setFundingOpportunityLoaded(true);
                setLoading(false);
            } catch (err) {
                setError(err.message);
                setLoading(false);
            }
        };

        fetchFundingOpportunity();
    }, [id]);
	
	useEffect(() => {
		if (fundingOpportunityLoaded) {
			// Fetch the FundingOpportunity object from the backend
		    const fetchAppCountPerFundingOpportunity = async () => {
		        try {
		            const response = await axios.get(`http://localhost:8080/api/funding-opportunities/getCountApplicationByFundingOpportunity/${id}?program=${fundingOpportunity.program}&fiscalyear=${fundingOpportunity.fy}`);
		            setCountApps(response.data);
					console.log(response.data);
					console.log(countApps);
					
					// Compute applicationNumber dynamically
					const newApplicationNumber = fundingOpportunity
					    ? fundingOpportunity?.program === 'Research'
					        ? `RP${((fundingOpportunity?.fy - 2000) * 10000 + response.data).toString()}`
					        : fundingOpportunity?.program === 'Recruitment'
					        ? `RR${((fundingOpportunity?.fy - 2000) * 10000 + response.data).toString()}`
					        : `PD${((fundingOpportunity?.fy - 2000) * 10000 + response.data).toString()}`
					    : null;
					if (newApplicationNumber){
						setProposalId(newApplicationNumber);
					}
					
		        } catch (err) {
		            setError(err.message);
		        }
		    };

	
		    fetchAppCountPerFundingOpportunity();
		}
	}, [id,fundingOpportunity?.program,fundingOpportunity?.fy]);

    useEffect(() => {
        // Fetch the GrantApplication object from the backend only if step > 1
        if (step > 1 && applicationId) {
            const fetchGrantApplication = async () => {
                try {
                    const response = await axios.get(`http://localhost:8080/api/grant-applications/${applicationId}`);
                    console.log(response.data);
                    setGrantApplication(response.data);
                    setLoading(false);
                } catch (err) {
                    setError(err.message);
                    setLoading(false);
                }
            };

            fetchGrantApplication();
        }
    }, [step, applicationId]); // Re-run the effect when `step` or `applicationId` changes

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    if (!fundingOpportunity) {
        return <div>Funding Opportunity not found</div>;
    }



    return (
        <div className="container mt-5">
            <label style={{ fontWeight: 'bold', marginLeft: '10px' }}>
                Program:
                <span style={{ color: 'blue', marginLeft: '10px' }}>{fundingOpportunity.program}</span>
            </label>
            <label style={{ fontWeight: 'bold', marginLeft: '10px' }}>
                Mechanism:
                <span style={{ color: 'blue', marginLeft: '10px' }}>{fundingOpportunity.title}</span>
            </label>
            <label style={{ fontWeight: 'bold', marginLeft: '10px' }}>
                Fiscal Year:
                <span style={{ color: 'blue', marginLeft: '10px' }}>{fundingOpportunity.fy}</span>
            </label>
            <label style={{ fontWeight: 'bold', marginLeft: '10px' }}>
                Cycle:
                <span style={{ color: 'blue', marginLeft: '10px' }}>{fundingOpportunity.cycle}</span>
            </label>
            <form onSubmit={handleSubmit} className="card p-4">
                {step === 1 && (
                    <div>
                        <h5>Step 1: Project Title and Type</h5>
                        <div className="form-group mb-2">
                            {validationErrors.projectTitle && (
                                <div className="text-danger">{validationErrors.projectTitle}</div>
                            )}
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Project Title"
                                value={projectTitle}
                                onChange={(e) => setProjectTitle(e.target.value)}
                            />
                        </div>
                        <div className="form-group mb-2">
                            {validationErrors.projectType && (
                                <div className="text-danger">{validationErrors.projectType}</div>
                            )}
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Project Type"
                                value={projectType}
                                onChange={(e) => setProjectType(e.target.value)}
                            />
                        </div>

                        <button type="button" className="btn btn-primary" onClick={handleNext}>Next</button>
                    </div>
                )}
                {step === 2 && (
                    <div>
                        <h5>Project Number: {applicationNumber}</h5><h5> Project Title: {grantApplication?.projectTitle}</h5>
                        <h5>Step 2: Contact Information</h5>
                        <div className="form-group mb-2">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Contact Information"
                                value={contactInfo}
                                onChange={(e) => setContactInfo(e.target.value)} />
                         </div>
                         <button type="button" className="btn btn-secondary mb-2 me-2" onClick={handleBack}>Back</button>
                         <button type="button" className="btn btn-primary mb-2" onClick={handleNext}>Next</button>
                    </div>
                )}
                {step === 3 && (
                    <div>
                        <h5>Project Number: {applicationId}</h5><h5> Project Title: {grantApplication?.projectTitle}</h5>
                        <h5>Step 3: Project Details</h5>
                        <div className="form-group mb-2">
                            <textarea placeholder="Project Details"
                                value={projectDetails}
                                onChange={(e) => setProjectDetails(e.target.value)}
                                style={{ width: '50vw', minWidth: '340px', maxWidth: '1200px' }}
                            />
                        </div>
                        <button type="button" className="btn btn-secondary mb-2 me-2" onClick={handleBack}>Back</button>
                        <button type="button" className="btn btn-primary mb-2" onClick={handleNext}>Next</button>
                    </div>
                )}
                {step === 4 && (
                    <div>
                        <h5>Project Number: {applicationId}</h5><h5> Project Title: {grantApplication?.projectTitle}</h5>
                        <h5>Step 4: Support Documents</h5>
                        <div className="form-group mb-2">
                            <input type="file" onChange={(e) => setSupportDocuments(e.target.files[0])} />
                        </div>
                        <button type="button" className="btn btn-secondary mb-2 me-2" onClick={handleBack}>Back</button>
                        <button type="button" className="btn btn-primary mb-2 me-2" onClick={handleNext}>Next</button>
                    </div>
                )}
                {step === 5 && (
                    <div>
                        <h5>Project Number: {applicationId}</h5><h5> Project Title: {grantApplication?.projectTitle}</h5>
                        <h5>Step 5: Project Budget</h5>
                        <div className="form-group mb-2">
                            <input type="number" placeholder="Personnel Cost" value={personnelCost} onChange={(e) => setPersonnelCost(e.target.value)} />
                            <input type="number" placeholder="Fringe Benefit" value={fringeBenefit} onChange={(e) => setFringeBenefit(e.target.value)} />
                            <input type="number" placeholder="Equipment Cost" value={equipmentCost} onChange={(e) => setEquipmentCost(e.target.value)} />
                            <input type="number" placeholder="Indirect Cost" value={indirectCost} onChange={(e) => setIndirectCost(e.target.value)} />
                        </div>
                        <button type="button" className="btn btn-secondary mb-2 me-2" onClick={handleBack}>Back</button>
                        <button type="button" className="btn btn-primary mb-2 me-2" onClick={handleNext}>Submit Application</button>
                    </div>
                )}
            </form>
        </div>
    );
}

export default GrantApplicationForm;