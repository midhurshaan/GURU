import React from 'react';
import { NavbarMinimal } from "./components/NavbarMinimal"
import { BrowserRouter, Routes, Route } from "react-router-dom"
import { StatisticalAnalysis } from "./pages/StatisticalAnalysis"
import { FeaturesGrid } from "./pages/Tips"
import { FinancialRecords } from "./pages/FinancialRecords"


function App() {
  return (
    <div className="App">
      <div style={{display:"flex"}}>
      <BrowserRouter>
        <NavbarMinimal />
          <Routes>
            <Route index element={<StatisticalAnalysis />} />
            <Route path="/tips" element={<FeaturesGrid />} />
            <Route path="/financial" element={<FinancialRecords />} />
          </Routes>
        </BrowserRouter>
      </div>
    </div>
  );
}

export default App;
