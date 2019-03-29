import React, { Component } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/react-bootstrap-table/dist/react-bootstrap-table-all.min.css';


import { Row, Container } from 'react-bootstrap';
import { Link } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <Container style={{ marginTop:50, marginLeft:100 }}>
        <div className="App">
          <Row style={{ marginLeft: 100, marginBottom: 10 }}>
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
              <ul class="navbar-nav">
                <li class="nav-item" style={{ minWidth: 100, marginRight: 20, marginLeft :100 }}>
                  <Link to="/unit/search/export" >Danh mục Đơn Vị Gửi Mẫu </Link>
                </li>
                <li class="nav-item" style={{ minWidth: 100, marginRight: 20 }}>
                  <Link to="/unit/upload">Upload Danh Mục Đơn Vị Gửi Mẫu</Link>
                </li>
                <li class="nav-item" style={{ minWidth: 100, marginRight: 20 }}>
                  <Link to="/unit/addNew">Nhập Thông Tin Đơn Vị Gửi Mẫu </Link>
                </li>
                
               </ul>
            </nav>
          </Row>
        </div>
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"></link>
      </Container>
    );
  }
}

export default App;
