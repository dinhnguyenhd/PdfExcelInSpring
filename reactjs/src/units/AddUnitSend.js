import React, { Component } from 'react';
import { Container, Row } from 'react-bootstrap';
import { Form, Button, Col } from 'react-bootstrap';
import * as EmailValidator from 'email-validator';

export default class AddUnitSend extends Component {
    constructor(props) {
        super(props);
        this.changeCode = this.changeCode.bind(this);
        this.changeName = this.changeName.bind(this);
        this.changeAddress = this.changeAddress.bind(this);
        //this.changeDvtt = this.changeDvtt.bind(this);
        this.changeEmail = this.changeEmail.bind(this);
        this.changeTaxCode = this.changeTaxCode.bind(this);
        this.changeMobile = this.changeMobile.bind(this);
        this.validateForm = this.validateForm.bind(this);
        this.state = {
            code: '',
            name: '',
            address: '',
            taxCode: '',
            email: '',
            mobile: '',
            dvtt: '',
            listDvtt: [],
            codeError: '',
            nameError: '',
            addressError: '',
            flag: true,
            emailError: ''

        }
    }
    changeCode = (event) => {
        this.setState({
            code: event.target.value
        })
    }
    changeName = (event) => {
        this.setState({
            name: event.target.value
        })
    }
    changeDvtt = (event) => {
        this.setState({
            dvtt: event.target.value
        })
    }
    changeAddress = (event) => {
        this.setState({
            address: event.target.value
        })
    }
    changeEmail = (event) => {
        this.setState({
            email: event.target.value
        })
    }
    changeTaxCode = (event) => {
        this.setState({
            taxCode: event.target.value
        })
    }
    changeMobile = (event) => {
        this.setState({
            mobile: event.target.value
        })
    }
    reset = () => {
        this.setState({
            code: '',
            name: '',
            address: '',
            taxCode: '',
            email: '',
            mobile: '',
            dvtt: '',
            codeError: '',
            nameError: '',
            addressError: '',
            emailError: ''
        })
    }
    validateForm = () => {
        if (this.state.code.trim().length === 0) {
            this.setState({
                codeError: "Nhập mã đơn vị",
                flag: false
            })
        } else {
            this.setState({
                codeError: " ",
            })
        }
        if (this.state.name.trim().length === 0) {
            this.setState({
                nameError: "Nhập tên đơn vị",
                flag: false
            })
        } else {
            this.setState({
                nameError: " ",
            })
        }
        if (this.state.address.trim().length === 0) {
            this.setState({
                addressError: "Nhập địa chỉ đơn vị",
                flag: false
            })
        } else {
            this.setState({
                addressError: " ",
            })
        }
        var result = EmailValidator.validate(this.state.email); // true
        if (result ===false){
            this.setState({
                emailError: "Kiểm Tra Lại Email ",
                flag: false
            })
        }
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

    addNewItems = (event) => {
        event.preventDefault();
        this.validateForm();
        if (this.state.flag === true) {


            var axios = require('axios');
            axios.post('http://localhost:8090/unit/add',
                {
                    code: this.state.code,
                    name: this.state.name,
                    address: this.state.address,
                    taxCode: this.state.taxCode,
                    email: this.state.email,
                    mobile: this.state.mobile,
                    dvtt: this.state.dvtt

                })
                .then((response) => {
                    //console.log(response.data);
                    if (response.data === -1) {
                        alert(' Vui lòng kiểm tra lại dư liệu bạn vừa nhập! ');
                    }
                    if (response.data === 1) {
                        alert(" Bạn đã thêm mới thành công !");

                    }

                })
                .catch(function (error) {
                    //console.log(error);
                });
        }

    }

    render() {

        return (

            <Container>
                <div class="panel panel-success">
                    <Row>
                        <div class="panel-heading" style={{ fontSize: 20, color: "#9932CC", backgroundColor: "#F8F8FF", marginBottom: 15 }}>Nhập Thông Tin Danh Mục Đơn Vị Gửi Mẫu</div>
                    </Row>
                    <Row>
                        <div class="panel-body">
                            <Form>
                                <Row>
                                    <Col xs="6">
                                        <Row>
                                            <Form.Group controlId="formBasicDvtt">
                                                <Form.Label>Mã Đơn Vị </Form.Label>
                                                <Form.Control type="text" placeholder="Mã đơn vị" onChange={this.changeCode} value={this.state.code} />
                                            </Form.Group>
                                        </Row>
                                        <Row style={{ color: "#FF1493" }}>{this.state.codeError}</Row>
                                    </Col>
                                    <Col xs="6">
                                        <Row>
                                            <Form.Group controlId="formBasicName">
                                                <Form.Label>Tên Đơn vị </Form.Label>
                                                <Form.Control type="text" placeholder="Tên đơn vị" onChange={this.changeName} value={this.state.name} />
                                            </Form.Group>
                                        </Row>
                                        <Row style={{ color: "#FF1493" }}>{this.state.nameError}</Row>
                                    </Col>

                                </Row>
                                <Row>
                                    <Col xs="6">
                                        <Row>
                                            <Form.Group controlId="formBasicAddress">
                                                <Form.Label>Địa Chỉ </Form.Label>
                                                <Form.Control type="text" placeholder="Nhập địa chỉ " onChange={this.changeAddress} value={this.state.address} />
                                            </Form.Group>
                                        </Row>
                                        <Row style={{ color: "#FF1493" }}>{this.state.addressError}</Row>
                                    </Col>
                                    <Col xs="6">
                                        <Row>
                                            <Form.Group controlId="formBasicTaxCode">
                                                <Form.Label>Mã Số Thuế </Form.Label>
                                                <Form.Control type="text" placeholder="Nhập mã số thuế" onChange={this.changeTaxCode} value={this.state.taxCode} />
                                            </Form.Group>
                                        </Row>
                                        <Row></Row>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col xs="6">
                                        <Row>
                                            <Form.Group controlId="formBasicQuantity">
                                                <Form.Label>Email</Form.Label>
                                                <Form.Control type="email" placeholder="Nhập email" onChange={this.changeEmail} value={this.state.email} />
                                            </Form.Group>
                                        </Row>
                                        <Row style={{ color: "#FF1493" }}>{this.state.emailError}</Row>
                                    </Col>
                                    <Col xs="6">
                                        <Row>
                                            <Form.Group controlId="formBasicMobile">
                                                <Form.Label>Số điện thoại</Form.Label>
                                                <Form.Control type="number" placeholder="Nhập số điện thoại" onChange={this.changeMobile} value={this.state.mobile} />
                                            </Form.Group>
                                        </Row>
                                    </Col>
                                </Row>
                                <Row>
                                    <Form.Group controlId="selectDvtt">
                                        <Form.Label>Đơn Vị Trực Thuộc </Form.Label>
                                        <Form.Control as="select" onChange={(e) => this.setState({ dvtt: e.target.value })}>
                                            {this.state.listDvtt.map((row) => <option key={row.id} value={row.name}>{row.name}</option>)}
                                        </Form.Control>
                                    </Form.Group>
                                </Row>
                                <Row>
                                    <Col xs="6">
                                        <Button variant="outline-primary" type="submit" onClick={this.addNewItems} style={{ marginLeft: -20 }}>
                                            Thêm
                                    </Button>
                                    </Col>
                                    <Col xs="6">
                                        <Button variant="outline-info" type="reset" style={{ marginLeft: 20 }} onClick={this.reset}>
                                            Reset
                                    </Button>
                                    </Col>
                                </Row>
                            </Form>
                        </div>
                    </Row>
                </div>
            </Container>

        )
    }
}
