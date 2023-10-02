import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function HomePage() {
  const navigate = useNavigate();

  // Logout function to remove the JWT token from localStorage
  function logout() {
    localStorage.removeItem('jwtResponse');
    // Redirect to the login page or any other desired page
    navigate('/login');
  }

  useEffect(() => {
    // Check if the JWT token is present in localStorage
    const jwtToken = localStorage.getItem('jwtResponse');

    // If not authenticated, redirect to the login page
    if (jwtToken == null) {
      navigate('/login');
    }
  }, [navigate]);
  return (
    <nav>
      <h1 href="index.html">Facility Booking</h1>
      <div>
        <ul id="navbar">
          <li>
            <a href="index.html" className="active">
              Home
            </a>
          </li>
          <li>
            <a href="index.html">Booking</a>
          </li>
          <li>
            <a href="index.html">Contact</a>
          </li>
          <li>
            <a href="index.html">About</a>
          </li>
        </ul>
      </div>
      <div>
        {/* <AccountCircleIcon className="profileIcon" /> */}
        <AccountMenu />
      </div>
    </nav>
  );
}

export default HomePage;
