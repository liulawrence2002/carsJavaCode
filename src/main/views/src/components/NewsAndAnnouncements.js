import React, { useEffect, useState } from 'react';
import axios from 'axios';

function NewsAndAnnouncements() {
    const [news, setNews] = useState([]);

    // Fetch news and announcements from the backend
    useEffect(() => {
        const fetchNews = async () => {
            try {
                const response = await axios.post('http://localhost:8080/api/news/getAllNews'); // Change to POST
                setNews(response.data);
            } catch (error) {
                console.error('Failed to fetch news and announcements', error);
            }
        };

        fetchNews();
    }, []);

    return (
        <div className="container mt-5">
            <h1>News and Announcements</h1>
            {news.length > 0 ? (
                <ul className="list-group">
                    {news.map((item) => (
                        <li key={item.id} className="list-group-item">
                            <h3>{item.title}</h3>
                            <p>{item.description}</p>
                            <small className="text-muted">{item.date}</small>
                        </li>
                    ))}
                </ul>
            ) : (
                <p>No news or announcements available.</p>
            )}
        </div>
    );
}

export default NewsAndAnnouncements;