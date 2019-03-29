import React, { Component } from 'react';
import { Table, Container, Row, Col, Button } from 'react-bootstrap';
import readExcel from 'read-excel-file';
import RowTable from '../units/RowTable';
export default class UploadFiles extends Component {
    constructor(props) {
        super(props);
        this.uploadFile = this.uploadFile.bind(this);
        this.saveUpload = this.saveUpload.bind(this);
        this.state = {
            data: [],
            errorList: [],
            error: false
        }
    }
    uploadFile = () => {
        const input = document.getElementById('input');
        var newList = [];
        readExcel(input.files[0]).then((rows) => {
          
            if (rows.length === 0) return
            else {
                var index = 0;
                rows.forEach(element => {

                    var code = element[0];
                    var name = element[1];
                    var address = element[2];
                    var taxCode = element[3];
                    var email = element[4];
                    var mobile = element[5];
                    var dvtt = element[6];
                    var json = {
                        'code': code,
                        'name': name,
                        'address': address,
                        'taxCode': taxCode,
                        'email': email,
                        'mobile': mobile,
                        'dvtt': dvtt
                    }
                    newList.push(json);
                    console.log(newList);
                    // check data trung : 
                    const axios = require('axios');
                    if (index > 0) {
                        console.log('indev ' + index);
                        axios.get('http://localhost:8090/unit/getbyId/' + code)
                            .then((response) => {
                                console.log(response.data);
                                if (response.data.name.trim().length !== 0) {
                                    this.setState({
                                        error: true
                                    })
                                    var list = this.state.errorList;
                                    list.push(code);
                                    this.setState({
                                        errorList: list
                                    })
                                }

                            }).catch(function (error) {
                                console.log(error);
                            });
                    }
                    index++;
                });
                newList.shift();
                //console.log(newList);
                //console.log(this.state.errorList);
                this.setState({
                    data: newList
                })
            }
        })
    }
    saveUpload = (event) => {
        event.preventDefault();
        var axios = require('axios');
        axios.post('http://localhost:8090/unit/upload',
            {
                data: this.state.data,
            })
            .then((response) => {
                if (response.data === -1) {
                    this.setState({
                        error: true
                    })
                }
                if (response.status === 200) {
                    alert(" Bạn upload file thành công !");
                }
            })
            .catch(function (error) {
                //console.log(error);
            });

    }

    render() {
        return (
            <div>
                <Container>
                    <Row>
                        {
                            this.state.error &&
                            <div style={{ fontSize: 20, color: "#DC143C" }}>Vui lòng kiểm tra lại dữ liệu upload ! </div>
                        }
                    </Row>
                    <Row style={{ marginTop: 20, marginBottom: 20 }}>
                        <Table>
                            <thead>
                                <tr>
                                    <th>Mã Đơn Vị </th>
                                    <th>Tên Đơn Vị</th>
                                    <th>Địa Chỉ </th>
                                    <th>Mã Số Thuế</th>
                                    <th>Email</th>
                                    <th>Điện Thoại </th>
                                    <th>Đơn Vị Trực Thuộc</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.state.data.map((item, value) => {
                                    return (
                                        <RowTable row={item} rowId={item.code} key={item.code}
                                        />
                                    )
                                })}
                            </tbody>
                        </Table>
                    </Row>
                    <Row>
                        <Col xs="6">
                            <input type="file" id="input" onChange={this.uploadFile} />
                        </Col>
                        <Col xs="6">
                            <Button variant="outline-info" type="reset" style={{ marginLeft: 20 }} onClick={this.saveUpload}>
                                Save
                            </Button>
                        </Col>
                    </Row>

                </Container>
            </div>
        )
    }
}
