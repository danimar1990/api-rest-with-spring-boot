import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import create from './pages/create';
import edit from './pages/edit';
import list from './pages/list';

const RoutesList = () => {
  return (
    <Router>
      <Routes>
        <Route path='/' index element={<list />} />
        <Route path='/edit/:id' element={<edit />} />
        <Route path='/create' element={<create />} />
      </Routes>
    </Router>
  );
};
export default RoutesList;
