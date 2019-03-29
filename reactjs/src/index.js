import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import DisplayList from './retails/DisplayList';
import AddRetails from './retails/AddRetails';
import AddBill from './bills/AddBill';
import Report from './bills/Report';
import UnitTable from './units/UnitTable';
import AddUnitSend from './units/AddUnitSend';
import UploadFiles from './units/UploadFiles';
import Home from './Home';
import SearchLog from './logs/SearchLog';
import SearchHiv from './hivs/SearchHiv';
import TableEdit from './hivs/tables/TableEdit';


import { BrowserRouter as Router, Route } from 'react-router-dom'
const routing = (
    <Router>
        <div>
            <Route path="/" component={App} />
            <Route path="/home" component={Home} />
            <Route path="/retail/list" component={DisplayList} />
            <Route path="/retail/add" component={AddRetails} />
            <Route path="/bill/add" component={AddBill} />
            <Route path="/bill/report" component={Report} /> 
            <Route path="/unit/search/export" component={UnitTable} /> 
            <Route path="/unit/upload" component={UploadFiles} /> 
            <Route path="/unit/addNew" component={AddUnitSend} /> 
            <Route path="/log/search" component={SearchLog} /> 
            <Route path="/hiv/search" component={SearchHiv} /> 
            <Route path="/hiv/table/edit" component={TableEdit} /> 
            
        </div>
    </Router>
)
ReactDOM.render(routing, document.getElementById('root'));
serviceWorker.unregister();
