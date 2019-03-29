import React, { Component } from 'react';
import { Container, Button, Row, Modal } from 'react-bootstrap';
import Workbook from 'react-excel-workbook';
import { Form, Col } from 'react-bootstrap';
import ReactTable from 'react-table';
import 'react-table/react-table.css'

export default class UnitTable extends Component {

    constructor(props) {
        super(props);
        this.seachUnitSend = this.seachUnitSend.bind(this);
        this.onRowClicked = this.onRowClicked.bind(this);
        this.handleUpdateData = this.handleUpdateData.bind(this);
        this.handleClose = this.handleClose.bind(this);
        this.deleteRow = this.deleteRow.bind(this);
        this.updateRow = this.updateRow.bind(this);
        this.changeICode = this.changeICode.bind(this);
        this.changeIName = this.changeIName.bind(this);
        this.changeIAddress = this.changeIAddress.bind(this);
        this.changeITaxCode = this.changeITaxCode.bind(this);
        this.changeIEmail = this.changeIEmail.bind(this);
        this.changeIMobile = this.changeIMobile.bind(this);
        this.renderTable = this.renderTable.bind(this);
        this.changeAddressSearch = this.changeAddressSearch.bind(this);
        this.handleApprove = this.handleApprove.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleConfirm = this.handleConfirm.bind(this);
        this.state = {
            show: false,
            question: false,
            rowDelelted : '',
            dialog: false,
            codeSearch: '',
            nameSearch: '',
            addressSearch: '',
            mobileSearch: '',
            updateIcode: '',
            updateIName: '',
            updateIAddress: '',
            updateITaxCode: '',
            updateIEmail: '',
            updateIMobile: '',
            dvtt: '',
            listDvtt: [],
            data: [],
            columns: [
                {
                    Header: 'Mã Đơn Vị ',
                    accessor: 'code',
                    sortable: true,
                },
                {
                    Header: 'Tên Đơn Vị',
                    accessor: 'name',
                    sortable: true,
                },
                {
                    Header: 'Địa Chỉ ',
                    accessor: 'address',
                    sortable: true,

                },
                {
                    Header: 'Số điện thoại',
                    accessor: 'mobile',
                    sortable: true,

                },
                {
                    Header: 'Mã số thuế ',
                    accessor: 'taxCode',
                    sortable: true,

                },
                {
                    Header: 'Email ',
                    accessor: 'email',
                    sortable: true,

                },
                {
                    Header: 'Xóa ',
                    Cell: props => {
                        return (
                            <Button variant="outline-success" type="submit" onClick={() => {
                               // console.log(props.row.code);
                                this.handleConfirm(props.row)
                            }}>
                                Xóa
                            </Button>
                        )
                    }
                },
                {
                    Header: 'Cập nhật ',
                    Cell: props => {
                        return (
                            <Button variant="outline-success" type="submit" onClick={() => {
                                console.log(props.row.code);
                                this.updateRow(props.row)
                            }}>
                                Cập nhật
                            </Button>
                        )
                    }
                }
            ]
        }
    }
    handleConfirm = (row) => {
        //console.log(' data trong row ');
        //console.log(row);
        this.setState({
            dialog: true
        });
        this.setState({
            rowDelelted : row
        })
        //console.log('dong y hay ko ? handleConfirm '+ this.state.question);
        
    }
    handleApprove = ()=>{
        this.setState({
            dialog : false
        });
        //console.log('Dong du lieu bi xoa  rowDelelted ');
        //console.log(this.state.rowDelelted);
       this.deleteRow();
    }
    handleCancel = () => {
        this.setState({
            question: false,
            dialog: false
        })
    }
    renderTable = (newList) => {
        this.setState({
            data: newList
        });
    }
    deleteRow = () => {
        var row = this.state.rowDelelted;
        //console.log(' data trong hamf delete ' );
        //console.log(row);
        // show dialog :
        var pos = -1;
        this.state.data.forEach((element, index) => {
            // console.log(element);
            if (element.code.trim() === row.code.trim()) {
                pos = index;
                //console.log(' index ' + pos);
            }
        });
        if (pos > -1) {
            //this.state.data.splice(pos, 1);
            var newList = this.state.data;
            //console.log(newList);
            newList.splice(pos, 1);
            //console.log(newList);
            this.setState({
                data: []
            });
            // call API to delete it base on ID:
            var axios = require('axios');
            axios.delete('http://localhost:8090/unit/delete/' + row.code)
                .then((response) => {
                    this.setState(
                        {
                            data: newList
                        })
                    if (response.status === 200) {
                        alert(' Xoa Thanh Cong ');

                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        }

    }

    updateRow = (row) => {
        this.setState({
            updateIcode: row.code,
            updateIName: row.name,
            updateIAddress: row.address,
            updateIMobile: row.mobile,
            updateIEmail: row.email,
            updateITaxCode: row.taxCode,
            show: true,
        });
    }

    handleUpdateData = (event) => {
        this.setState({
            show: false
        });
        var axios = require('axios');
        axios.put('http://localhost:8090/unit/update', {
            code: this.state.updateIcode,
            name: this.state.updateIName,
            address: this.state.updateIAddress,
            taxCode: this.state.updateITaxCode,
            email: this.state.updateIEmail,
            mobile: this.state.updateIMobile,
            dvtt: this.state.dvtt
        })
            .then((response) => {
                //debugger;
                var newList = this.state.data;
                for (let index = 0; index < newList.length; index++) {
                    var element = newList[index];
                    if (element.code.trim() === this.state.updateIcode.trim()) {
                        element.name = this.state.updateIName;
                        element.address = this.state.updateIAddress;
                        element.taxCode = this.state.updateITaxCode;
                        element.email = this.state.updateIEmail;
                        element.mobile = this.state.updateIMobile;
                    }
                }
                this.setState({
                    data: []
                });
                this.setState({
                    data: newList
                });
            })
            .catch(function (error) {
                console.log(error);
            });
    }



    handleClose = (event) => {
        this.setState({
            show: false
        })
    }
    onRowClicked = (object, index) => {
        //console.log(index);

        this.setState({
            show: true
        })
    }
    changeCodeSearch = (event) => {
        this.setState({
            codeSearch: event.target.value
        })
    }
    changeNameSearch = (event) => {
        this.setState({
            nameSearch: event.target.value
        })
    }
    changeMobileSearch = (event) => {
        this.setState({
            mobileSearch: event.target.value
        })
    }
    changeMobileSearch = (event) => {
        this.setState({
            mobileSearch: event.target.value
        })
    }
    changeAddressSearch = (event) => {
        this.setState({
            addressSearch: event.target.value
        })
    }
    changeICode = (event) => {
        this.setState({
            updateIcode: event.target.value
        })
    }

    changeIName = (event) => {
        this.setState({
            updateIName: event.target.value
        })
    }
    changeIAddress = (event) => {
        this.setState({
            updateIAddress: event.target.value
        })
    }

    changeITaxCode = (event) => {
        this.setState({
            updateITaxCode: event.target.value
        })
    }

    changeIEmail = (event) => {
        this.setState({
            updateIEmail: event.target.value
        })
    }

    changeIMobile = (event) => {
        this.setState({
            updateIMobile: event.target.value
        })
    }

    seachUnitSend = (event) => {
        event.preventDefault();
        const axios = require('axios');
        axios.post('http://localhost:8090/unit/search',
            {
                code: this.state.codeSearch,
                name: this.state.nameSearch,
                address: this.state.addressSearch,
                mobile: this.state.mobileSearch

            })
            .then((response) => {
                //console.log(response.data);
                this.setState({
                    data: response.data
                });

            }).catch(function (error) {
                console.log(error);
            });
    }

    onChangePage = (currentPage) => {
        // next - prex - first - last do this action only
       // console.log('page ' + currentPage);
    }
    onChangeRowsPerPage = (total) => {
       // console.log('row per page ' + total);
    }
    componentDidMount() {
        
        var axios = require('axios');
        axios.get('http://localhost:8090/unit/list/dvtt')
            .then((response) => {
                //console.log(this.state.listDvtt);
                this.setState({
                    listDvtt: response.data
                });
            }).catch(function (error) {
                console.log(error);
            });
    }


    render() {

        return (
            <Container>
                <Row style={{ marginTop: 10, marginBottom: 0 }}>
                    <div class="panel-heading" style={{ fontSize: 20, color: "#9932CC", backgroundColor: "#F8F8FF", marginTop: 5, marginBottom: 15 }}>Tìm Kiếm Đơn Vị Gửi Mẫu</div>
                </Row>

                <Form>
                    <Row>
                        <Col xs="6">
                            <Form.Group controlId="formBasicCode">
                                <Form.Label> Mã Đơn Vị</Form.Label>
                                <Form.Control type="text" placeholder="Nhập mã đơn vị " onChange={this.changeCodeSearch} value={this.state.codeSearch} />
                            </Form.Group>
                        </Col>
                        <Col xs="6">
                            <Form.Group controlId="formBasicName">
                                <Form.Label>Tên Đơn Vị</Form.Label>
                                <Form.Control type="text" placeholder="Nhập tên đơn vị" onChange={this.changeNameSearch} value={this.state.nameSearch} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row>
                        <Col xs="6">
                            <Form.Group controlId="formBasicAddress">
                                <Form.Label> Địa chỉ </Form.Label>
                                <Form.Control type="text" placeholder="Enter your code" onChange={this.changeAddressSearch} value={this.state.addressSearch} />
                            </Form.Group>
                        </Col>
                        <Col xs="6">
                            <Form.Group controlId="formBasicName">
                                <Form.Label> Số điện thoại</Form.Label>
                                <Form.Control type="text" placeholder="Nhập số điện thoại" onChange={this.changeMobileSearch} value={this.state.mobileSearch} />
                            </Form.Group>
                        </Col>
                    </Row>
                    <Row style={{ marginTop: 20, marginBottom: 20 }}>
                        <Col xs="12">
                            <Button variant="outline-success" type="submit" onClick={this.seachUnitSend}>
                                Search
                            </Button>
                        </Col>
                    </Row>
                </Form>
                <ReactTable
                    data={this.state.data}
                    columns={this.state.columns}
                    showPagination={true}
                    defaultPageSize={5}
                    pageSizeOption={[5, 10, 20, 25, 50]} />

                <div className="row text-center" style={{ marginTop: '100px' }}>
                    <Workbook filename="dmdv.xlsx"
                        element={
                            <Button variant="outline-info" type="button">
                                Download
                            </Button>
                        }>
                        <Workbook.Sheet data={this.state.data} name="Danh Mục Đơn Vị">
                            <Workbook.Column label="Mã Đơn Vị" value="code" />
                            <Workbook.Column label="Tên Đơn Vị" value="name" />
                            <Workbook.Column label="Địa chỉ " value="address" />
                            <Workbook.Column label="Mã số thuế " value="taxCode" />
                            <Workbook.Column label="Email  " value="email" />
                            <Workbook.Column label="Điện Thoại " value="mobile" />
                        </Workbook.Sheet>
                    </Workbook>
                </div>
                <Row>
                    <>
                        <Modal show={this.state.show} onHide={this.handleClose}>
                            <Modal.Header closeButton>
                                <Modal.Title>Thông Tin Đơn Vị Gửi Mẫu </Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                <Form>
                                    <Row>
                                        <Col xs="6">
                                            <Form.Group controlId="formBasicName">
                                                <Form.Label>Mã Đơn Vị </Form.Label>
                                                <Form.Control type="text" disabled placeholder="Enter name" onChange={this.changeICode} value={this.state.updateIcode} />
                                            </Form.Group>
                                        </Col>
                                        <Col xs="6">
                                            <Form.Group controlId="formBasicCode">
                                                <Form.Label>Tên Đơn Vị </Form.Label>
                                                <Form.Control type="text" placeholder="Enter your code" onChange={this.changeIName} value={this.state.updateIName} />
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col xs="6">
                                            <Form.Group controlId="formBasicQuantity">
                                                <Form.Label>Địa Chỉ</Form.Label>
                                                <Form.Control type="text" placeholder="Enter Quantity" onChange={this.changeIAddress} value={this.state.updateIAddress} />
                                            </Form.Group>
                                        </Col>
                                        <Col xs="6">
                                            <Form.Group controlId="formBasicPrice">
                                                <Form.Label>Mã Số Thuế</Form.Label>
                                                <Form.Control type="text" step="any" placeholder="Enter price" onChange={this.changeITaxCode} value={this.state.updateITaxCode} />
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col xs="6">
                                            <Form.Group controlId="formBasicQuantity">
                                                <Form.Label>Email</Form.Label>
                                                <Form.Control type="text" placeholder="Enter Quantity" onChange={this.changeIEmail} value={this.state.updateIEmail} />
                                            </Form.Group>
                                        </Col>
                                        <Col xs="6">
                                            <Form.Group controlId="formBasicPrice">
                                                <Form.Label>Số điện thoại</Form.Label>
                                                <Form.Control type="text" step="any" placeholder="Enter price" onChange={this.changeIMobile} value={this.state.updateIMobile} />
                                            </Form.Group>
                                        </Col>
                                    </Row>
                                    <Row>

                                        <Col xs="6">
                                            <Form.Group controlId="selectDvtt">
                                                <Form.Label>Đơn Vị Trực Thuộc </Form.Label>
                                                <Form.Control as="select" onChange={(e) => this.setState({ dvtt: e.target.value })}>
                                                    {this.state.listDvtt.map((row) => <option key={row.id} value={row.name}>{row.name}</option>)}
                                                </Form.Control>
                                            </Form.Group>
                                        </Col>

                                    </Row>
                                </Form>
                            </Modal.Body>
                            <Modal.Footer>
                                <Button variant="outline-info" onClick={this.handleUpdateData}>
                                    Cập nhật
                             </Button>
                                <Button variant="outline-dark" onClick={this.handleClose}>
                                    Hủy
                             </Button>
                            </Modal.Footer>
                        </Modal>
                    </>
                </Row>
                <Row>
                    <>
                        <Modal show={this.state.dialog} onHide={this.handleCancel}>
                            <Modal.Header closeButton>
                                <Modal.Title>Bạn có đồng ý xóa không ?</Modal.Title>
                            </Modal.Header>
                            <Modal.Footer>
                                <Button variant="secondary" onClick={this.handleApprove}>
                                    Đồng Ý
                                </Button>
                                <Button variant="primary" onClick={this.handleCancel}>
                                    Hủy bõ
                                </Button>
                            </Modal.Footer>
                        </Modal>
                    </>
                </Row>
            </Container>

        )
    }
}
