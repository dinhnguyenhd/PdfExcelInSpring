import React, { Component } from 'react';
import { Container, Row, Col, Form, Button } from 'react-bootstrap';
import ReactTable from 'react-table';
import "react-datepicker/dist/react-datepicker.css";

export default class SearchLog extends Component {
    constructor(props) {
        super(props);
        this.seachData = this.seachData.bind(this);
        this.searchLogWithNoUserTableFromDb = this.searchLogWithNoUserTableFromDb.bind(this);
        this.updateMultipeList = this.updateMultipeList.bind(this);
        this.changeDate = this.changeDate.bind(this);
        this.loadListUser = this.loadListUser.bind(this);
        this.loadListTable = this.loadListTable.bind(this);
        this.state = {
            source: 'db',
            begin: '',
            end: '',
            selectUserId: false,
            userId: '',
            tableName: '',
            selectTableName: false,
            beginMessage: '',
            endMessage: '',
            userMessage: '',
            tableMessage: '',
            date: '',
            listUser: [],
            listTable: [],
            data: [],
            columns: [
                {
                    Header: 'Time',
                    accessor: 'times',
                    sortable: true,
                    filterable: true
                },
                {
                    Header: 'Table Name',
                    accessor: 'entityName',
                    sortable: true,
                    filterable: true
                },
                {
                    Header: 'ID ',
                    accessor: 'id',
                    sortable: true,
                    filterable: true

                },
                {
                    Header: 'State',
                    accessor: 'state',
                    sortable: true,
                    filterable: true

                },
                {
                    Header: 'Description',
                    accessor: 'decription',
                    sortable: true,
                    filterable: true

                },
                {
                    Header: 'User Name ',
                    accessor: 'userID',
                    sortable: true,
                    filterable: true

                },
            ]

        }
    }
    loadListUser = (event) => {
        if (this.state.listUser.length === 0) {
            if (this.state.source === 'db') {
                this.loadListUserFromDB();
            }
            if (this.state.source === 'folder') {
                this.loadListUserFromFolder();
            }
        }
    }
    loadListTable = (event) => {
        if (this.state.listTable.length === 0) {
            if (this.state.source === 'db') {
                this.loadListTableFromDB();
            }
            if (this.state.source === 'folder') {
                this.loadListTableFromFolder();
            }
        }
    }

    changeDate = (date) => {
        this.setState({
            date: date
        });
    }
    componentDidMount() {
        if (this.state.source === 'db') {
            this.loadListTableFromDB();
            this.loadListUserFromDB();
        } else {
            this.loadListTableFromFolder();
            this.loadListUserFromFolder();
        }

    }
    updateMultipeList = (event) => {
        this.setState({
            source: event.target.value
        });
        if (event.target.value === 'db') {
            this.setState({
                listTable: [],
                listUser: []
            })
            this.loadListTableFromDB();
            this.loadListUserFromDB();

        } else {
            this.setState({
                listTable: [],
                listUser: []
            })
            this.loadListTableFromFolder();
            this.loadListUserFromFolder();
        }
    }
    loadListTableFromDB = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        axios.get('http://localhost:8090/db/search/list/table/' + begin + '/' + end)
            .then((response) => {
                //console.log(response.data);
                this.setState({
                    listTable: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    loadListUserFromDB = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        axios.get('http://localhost:8090/db/search/list/user/' + begin + '/' + end)
            .then((response) => {
                this.setState({
                    listUser: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    loadListTableFromFolder = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        axios.get('http://localhost:8090/folder/search/table/list/' + begin + '/' + end)
            .then((response) => {
                this.setState({
                    listTable: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    loadListUserFromFolder = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        axios.get('http://localhost:8090/folder/search/user/list/' + begin + '/' + end)
            .then((response) => {
                this.setState({
                    listUser: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    seachData = () => {
        if (this.state.begin.trim().length === 0) {
            this.setState({
                beginMessage: 'Chọn ngày bắt đầu. '
            });
        } else {
            this.setState({
                beginMessage: ''
            });
        }
        if (this.state.end.trim().length === 0) {
            this.setState({
                endMessage: 'Chọn ngày kết thúc.'
            });
        } else {
            this.setState({
                endMessage: ''
            });
        }
        if (this.state.userId.trim().length === 0) {
            this.setState({
                userMessage: 'Chọn lại User ID.'
            });
        } else {
            this.setState({
                userMessage: ''
            });
        }
        if (this.state.tableName.trim().length === 0 && (this.state.selectTableName === true)) {
            this.setState({
                tableMessage: 'Chọn Table.'
            });
        } else {
            this.setState({
                tableMessage: ''
            });
        }
        if (this.state.selectUserId === true && this.state.userId.trim().length === 0) {
            this.setState({
                userMessage: 'Chọn User'
            });
        } else {
            this.setState({
                userMessage: ''
            })
        }
        if (this.state.source === 'db') {
            this.seachDataFromDB();
        } else {
            this.seachDataFromFoloder();
        }
    }
    seachDataFromDB = () => {
        // Case 1: No select table Name, user Id
        if (this.state.selectUserId === false && this.state.selectTableName === false) {
            this.searchLogWithNoUserTableFromDb();
        }
        // select user name , begin , end 
        if (this.state.selectUserId === false && this.state.selectTableName !== false) {
            this.searchLogWithTableNotNullFromDb();
        }
        // select table name , begin , end 
        if (this.state.selectUserId !== false && this.state.selectTableName === false) {
            this.searchLogWithUserNameNotNullFromDb();
        }
        // select table name , user name , begin , end:  
        if (this.state.selectUserId !== false && this.state.selectTableName !== false) {
            this.searchLogWithUserAndTableNameNotNullFromDb();
        }

    }
    searchLogWithNoUserTableFromDb = (evnet) => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        axios.get('http://localhost:8090/db/search/list/' + begin + '/' + end)
            .then((response) => {
                //console.log(response.data);
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    searchLogWithTableNotNullFromDb = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        var table = this.state.tableName;
        //@GetMapping(value = "/search/list/table/{begin}/{end}/{tableName}")
        axios.get('http://localhost:8090/db/search/list/table/' + begin + '/' + end + '/' + table)
            .then((response) => {
                //console.log(response.data);
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    searchLogWithUserNameNotNullFromDb = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        var user = this.state.userId;
        axios.get('http://localhost:8090/db/search/list/user/' + begin + '/' + end + '/' + user)
            .then((response) => {
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }

    searchLogWithUserAndTableNameNotNullFromDb = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        var user = this.state.userId;
        var table = this.state.tableName;
        axios.get('http://localhost:8090/db/search/list/full/' + begin + '/' + end + '/' + user + '/' + table)
            .then((response) => {
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }

    /// Xu li truong hop cho source la Folder:
    seachDataFromFoloder = () => {
        // Case 1: No select table Name, user Id
        if (this.state.selectUserId === false && this.state.selectTableName === false) {
            this.searchLogWithNoUserTableFromFolder();
        }
        // select table name , begin , end 
        if (this.state.selectUserId === false && this.state.selectTableName !== false) {
            this.searchLogWithTableNameNotNullFromFolder();

        }
        // select table name , begin , end 
        if (this.state.selectUserId !== false && this.state.selectTableName === false) {
            this.searchLogWithUserNameNotNullFromFolder();
        }
        // select table name , user name , begin , end:  
        if (this.state.selectUserId !== false && this.state.selectTableName !== false) {
            this.searchLogWithUserAndTableNameNotNullFromFolder();
        }
    }
    searchLogWithNoUserTableFromFolder = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        axios.get('http://localhost:8090/folder/search/list/' + begin + '/' + end)
            .then((response) => {
                //console.log(response.data);
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    searchLogWithTableNameNotNullFromFolder = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        var table = this.state.tableName;
        //@GetMapping(value = "/search/list/table/{begin}/{end}/{tableName}")
        axios.get('http://localhost:8090/folder/search/list/table/' + begin + '/' + end + '/' + table)
            .then((response) => {
                //console.log(response.data);
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    searchLogWithUserNameNotNullFromFolder = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        var user = this.state.userId;
        axios.get('http://localhost:8090/folder/search/list/user/' + begin + '/' + end + '/' + user)
            .then((response) => {
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }

    searchLogWithUserAndTableNameNotNullFromFolder = () => {
        var axios = require('axios');
        var begin = this.state.begin;
        var end = this.state.end;
        var user = this.state.userId;
        var table = this.state.tableName;
        axios.get('http://localhost:8090/folder/search/list/full/' + begin + '/' + end + '/' + user + '/' + table)
            .then((response) => {
                this.setState({
                    data: response.data
                })
            }).catch(function (error) {
                console.log(error);
            });
    }
    render() {
        return (
            <Container>
                {/* Seach condition . */}
                <Row>
                    <Col xs="5">
                        <Form.Group as={Row} controlId="selectSource">
                            <Form.Label column sm={6}>
                                Đọc log từ :
                                </Form.Label>
                            <Col sm={6}>
                                <Form.Control as="select" value={this.state.source} onChange={this.updateMultipeList}>
                                    <option value='folder'>Folder</option>
                                    <option value='db'>DB</option>
                                </Form.Control>
                            </Col>

                        </Form.Group>
                    </Col>
                </Row>
                <Row>
                    <Col xs="5">
                        <Form.Group as={Row} controlId="beginDate">
                            <Form.Label column sm={6}>
                                Ngày bắt đầu
                                    </Form.Label>
                            <Col sm={6}>
                                <Form.Control type="date" required pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" onChange={(e) => this.setState({ begin: e.target.value })} />
                                <Row style={{ color: 'red' }}>{this.state.beginMessage}</Row>
                            </Col>
                        </Form.Group>
                        <Form.Group as={Row} controlId="endDate">
                            <Form.Label column sm={6}>
                                Ngày kết thúc
                                    </Form.Label>
                            <Col sm={6}>
                                <Form.Control type="date" required pattern="[0-9]{2}-[0-9]{2}-[0-9]{4}" onChange={(e) => this.setState({ end: e.target.value })} />
                                <Row style={{ color: 'red' }}>{this.state.endMessage}</Row>
                            </Col>

                        </Form.Group>
                    </Col>
                    <Col xs="4">
                        <Form.Group as={Row} controlId="selectUserId">
                            <Form.Label column sm={6}>
                                <Form.Check label=" Tài Khoản" onClick={this.loadListUser} onChange={(e) => this.setState({ selectUserId: !this.state.selectUserId })} />
                            </Form.Label>

                            <Col sm={6}>
                                <Row style={{ marginLeft: 10, color: 'red' }}>{this.state.userMessage}</Row>
                                <Form.Control as="select" value={this.state.userId} onChange={(e) => this.setState({ userId: e.target.value })}>
                                    {this.state.listUser.map((userName) => <option value={userName}>{userName}</option>)}}

                                </Form.Control>
                            </Col>
                        </Form.Group>
                        <Form.Group as={Row} controlId="selectTableName" >
                            <Form.Label column sm={6}>
                                <Form.Check label="Tên Bảng" onClick={this.loadListTable} onChange={(e) => this.setState({ selectTableName: !this.state.selectTableName })} />
                            </Form.Label>
                            <Col sm={6}>
                                <Row style={{ marginLeft: 10, color: 'red' }}>{this.state.tableMessage}</Row>
                                <Form.Control as="select" value={this.state.tableName} onChange={(e) => this.setState({ tableName: e.target.value })}>
                                    {this.state.listTable.map((tableName) => <option>{tableName}</option>)}}
                            </Form.Control>
                            </Col>
                        </Form.Group>
                    </Col>
                    <Col xs="3">
                        <Button type="submit" variant="outline-success" onClick={this.seachData}>Lấy dữ liệu (F5)  </Button>
                    </Col>
                </Row>
                {/* Display result alter press seach . */}
                <ReactTable
                    data={this.state.data}
                    columns={this.state.columns}
                    showPagination={true}
                    defaultPageSize={5}
                    pageSizeOption={[5, 10, 20, 25, 50]} />
            </Container>

        )
    }
}
