import React, { Component } from 'react';
import ReactTable from 'react-table';
import { Container, Row, Col, Form, Button, Modal } from 'react-bootstrap';
import "@kenshooui/react-multi-select/dist/style.css";
import MultiSelect from "@kenshooui/react-multi-select";
import Workbook from 'react-excel-workbook';
import MaterialTable from 'material-table';


export default class SearchHiv extends Component {
    constructor(props) {
        super(props);
        this.download = this.download.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.searchHiv = this.searchHiv.bind(this);
        this.loadListPlace = this.loadListPlace.bind(this);
        this.handleClose = this.handleClose.bind(this);
        this.showConfig = this.showConfig.bind(this);
        this.state = {
            begin: '',
            end: '',
            beginMessage: '',
            endMessage: '',
            selectPlace: false,
            place: '',
            show: false,
            listPlace: [],
            data: [],
            items: [],
            selectedItems: [],
            columns:
                [
                    {
                        Header: 'Thông Tin Khách Hàng',
                        columns:
                            [
                                {
                                    Header: 'Stt',
                                    accessor: "progress",
                                    Cell: (row) => row.index + 1,
                                },
                                {
                                    Header: 'Họ tên',
                                    accessor: 'hoten'
                                },
                                {
                                    Header: 'Mã Số',
                                    accessor: 'id'
                                },
                                {
                                    Header: 'Giới tính',
                                    accessor: 'gioitinh'
                                },
                                {
                                    Header: 'Năm Sinh',
                                    accessor: 'tuoi'

                                },
                                {
                                    Header: 'Địa Chỉ ',
                                    accessor: 'diachi'
                                },
                                {
                                    Header: 'Đối tượng',
                                    accessor: 'doituong'
                                },
                            ],
                    },
                    {
                        Header: 'Kết quả xét nghiệm',
                        columns:
                            [
                                {
                                    Header: 'Ngày lấy mẫu',
                                    accessor: 'ngaylm'
                                },
                                {
                                    Header: 'Ngày xét nghiệm',
                                    accessor: 'ngayxn'
                                },
                                {
                                    Header: 'SP',
                                    accessor: 'sp'
                                },
                                {
                                    Header: 'Kết luận',
                                    accessor: 'ketluan'
                                },
                                {
                                    Header: 'Kết quả khẳng định ',
                                    accessor: 'ketluankd'
                                },
                                {
                                    Header: 'Ghi chú ',
                                    accessor: 'ghichu'
                                },
                            ],
                    },
                ]
            ,
            configHeader:
                [
                    { title: 'Id', field: 'id' },
                    { title: 'Tên Sổ ', field: 'tenso' },
                    { title: 'Danh Sách Nhóm', field: 'listCode' }
                ],
            configdata:
                [
                    { id: '1', tenso: 'Baran', listCode: 1987 },
                    { id: '1', tenso: 'Baran', listCode: 1987 },
                    { id: '1', tenso: 'Baran', listCode: 1987 },
                    { id: '1', tenso: 'Baran', listCode: 1987 }]
        }
    }
    save = () => {
        alert('save naof - xoa song rui save lai ');
        var axios = require('axios');
        console.log(' data truoc khi save ');
        console.log(this.state.configdata);
        axios.post('http://localhost:8090/hiv/config/save',
            {
                list: this.state.configdata
            }).then((response) => {
                console.log(response.data);
            }).catch(function (error) {
                console.log(error);
            });
    }
    reset = () => {
        alert('calll api delete thui !  ');
        var axios = require('axios');
        axios.get('http://localhost:8090/hiv/config/delete').then((response) => {
            console.log(response.data);
            this.setState({
                configdata: []
            });
        }).catch(function (error) {
            console.log(error);
        });
    }
    showConfig = () => {
        var axios = require('axios');
        axios.get('http://localhost:8090/hiv/list/config').then((response) => {
            console.log(response.data);
            this.setState({
                configdata: response.data
            });
        }).catch(function (error) {
            console.log(error);
        });
        this.setState({
            show: true
        });
    }
    handleClose = () => {

        this.setState({
            show: false
        })
    }
    loadListPlace = () => {
        if (this.state.selectPlace === false) {
            var axios = require('axios');
            axios.get('http://localhost:8090/hiv/list/place').then((response) => {
                this.setState({
                    listPlace: response.data
                });
            }).catch(function (error) {
                console.log(error);
            });
        }
    }
    handleChange(selectedItems) {
        this.setState({ selectedItems });
        console.log(this.state.selectedItems);
    }
    searchHiv = () => {
        console.log('begin input');
        console.log(this.state.selectedItems);
        console.log(this.state.place);
        console.log(this.state.begin);
        console.log(this.state.end);
        console.log('end input');

        this.validateForm();
        var axios = require('axios');
        axios.post('http://localhost:8090/hiv/search',
            {
                begin: this.state.begin,
                end: this.state.end,
                place: this.state.place,
                list: this.state.selectedItems
            }).then((response) => {
                this.setState({
                    data: response.data
                });
                console.log(response.data);
            }).catch(function (error) {
                console.log(error);
            });
    }
    validateForm = () => {
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
    }
    componentDidMount() {
        if (this.state.selectPlace === false) {
            var axios = require('axios');
            axios.get('http://localhost:8090/hiv/list/doituong').then((response) => {
                this.setState({
                    items: response.data
                });
                console.log(response.data);
            }).catch(function (error) {
                console.log(error);
            });
        }
    }
    download = () => {
        var axios = require('axios');
        axios({
            method: 'post',
            url: 'http://localhost:8090/hiv/downloadFile',
            data:
            {
                begin: this.state.begin,
                end: this.state.end,
                place: this.state.place,
                list: this.state.selectedItems,
            },
            responseType: 'blob',
        }
        ).then((response) => {
            const url = window.URL.createObjectURL(new Blob([response.data]));
            const link = document.createElement('a');
            link.href = url;
            link.setAttribute('download', 'thongtinbn.pdf');
            document.body.appendChild(link);
            link.click();
        }).catch(function (error) {
            console.log(error);
        });
    }
    render() {

        const { items, selectedItems } = this.state;
        return (
            <Container>
                <Row style={{ marginTop: 20, marginBottom: 20 }}>
                    <Button type="submit" size='sm' onClick={this.showConfig.bind(this)} variant="outline-primary" style={{ marginLeft: 20, marginRight: 20 }}>Cấu hình xét nghiệm HIV</Button>
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
                        <Form.Group as={Row} controlId="selectPlace" >
                            <Form.Label column sm={6}>
                                <Form.Check label="Nơi chỉ định" onClick={this.loadListPlace} onChange={(e) => this.setState({ selectPlace: !this.state.selectPlace })} />
                            </Form.Label>
                            <Col sm={6}>
                                <Row style={{ marginLeft: 10, color: 'red' }}>{this.state.tableMessage}</Row>
                                <Form.Control as="select" value={this.state.place} onChange={(e) => this.setState({ place: e.target.value })}>
                                    {this.state.listPlace.map((place) => <option>{place.place}</option>)}}
                            </Form.Control>
                            </Col>
                        </Form.Group>
                    </Col>
                    <Col xs="3" >
                        <Form.Label>
                            ĐỐI TƯỢNG :
                        </Form.Label>
                        <MultiSelect
                            items={items}
                            selectedItems={selectedItems}
                            onChange={this.handleChange}
                            showSelectedItems={false}
                            showSelectAll={false}
                            responsiveHeight={150}
                        />
                    </Col>
                    <Col xs="3">
                        <Row style={{ marginTop: 30, marginBottom: 10 }}>
                            <Button type="submit" onClick={this.searchHiv} variant="outline-success" style={{ width: 200 }} >Lấy dữ liệu (F5)  </Button>
                        </Row>
                        <Row style={{ marginTop: 10, marginBottom: 10 }}>
                            <Workbook filename="thongtinbn.xlsx" element={
                                <Button type="submit" variant="outline-primary" style={{ width: 200 }}> Xuất Excel </Button>
                            }>
                                <Workbook.Sheet data={this.state.data} name="Thông Tin Xét Nghiệm">
                                    <Workbook.Column label="Họ Tên" value="hoten" />
                                    <Workbook.Column label="Mã BN" value="id" />
                                    <Workbook.Column label="Giới tính " value="gioitinh" />
                                    <Workbook.Column label="Tuổi" value="tuoi" />
                                    <Workbook.Column label="Địa chỉ  " value="diachi" />
                                    <Workbook.Column label="Đối tượng " value="doituong" />
                                    <Workbook.Column label="Ngày lấy mẫu" value="ngaylm" />
                                    <Workbook.Column label="Ngày xét nghiệm " value="ngayxn" />
                                    <Workbook.Column label="SP" value="sp" />
                                    <Workbook.Column label="Kết luận " value="ketluan" />
                                    <Workbook.Column label="Kết luận " value="ketluankd" />
                                    <Workbook.Column label="Ghi Chú " value="ghichu" />
                                </Workbook.Sheet>
                            </Workbook>
                        </Row>
                        <Row style={{ marginTop: 10, marginBottom: 10 }}>
                            <Button type="submit" variant="outline-primary" onClick={this.download} style={{ width: 200 }}> In báo cáo </Button>
                        </Row>
                    </Col>
                    <Col xs="3">
                    </Col>
                </Row>
                <Row style={{ minHeight: 30 }}>
                    <br></br>
                </Row>
                <ReactTable
                    data={this.state.data}
                    columns={this.state.columns}
                    showPagination={true}
                    defaultPageSize={5}
                    showPageJump={true}
                    pageSizeOption={[5, 10, 20, 25, 50]}
                />
                <Row>
                    <>
                        <Modal show={this.state.show} onHide={this.handleClose}>
                            <Modal.Header closeButton>
                                <Modal.Title>Cấu hình dịch vụ xét nghiệm </Modal.Title>
                            </Modal.Header>
                            <Modal.Body>
                                <Row style={{ marginTop: 20, marginBottom: 20 }}>
                                    <Button type="submit" size='sm' onClick={this.save.bind(this)} variant="outline-primary" style={{ marginLeft: 20, marginRight: 20 }}>Save</Button>
                                    <Button type="submit" size='sm' onClick={this.reset.bind(this)} variant="outline-primary" style={{ marginLeft: 20, marginRight: 20 }} >Làm mới </Button>
                                </Row>
                                <MaterialTable
                                    columns={this.state.configHeader}
                                    data={this.state.configdata}
                                    title={''}
                                    searchable={false}
                                    editable={{
                                        onRowAdd: (newData) => new Promise((resolve, reject) => {
                                            setTimeout(() => {
                                                {
                                                    const data = this.state.configdata;
                                                    data.push(newData);
                                                    this.setState({ configdata : data }, () => resolve());
                                                }

                                                resolve();
                                            }, 1000);
                                        }),
                                        onRowUpdate: (newData, oldData) => new Promise((resolve, reject) => {
                                            setTimeout(() => {
                                                {
                                                    const data = this.state.configdata;
                                                    const index = data.indexOf(oldData);
                                                    data[index] = newData;
                                                    this.setState({ configdata :data }, () => resolve());
                                                }
                                                resolve();
                                            }, 1000);
                                        }),
                                        onRowDelete: (oldData) => new Promise((resolve, reject) => {
                                            setTimeout(() => {
                                                {
                                                    let data = this.state.configdata;
                                                    const index = data.indexOf(oldData);
                                                    data.splice(index, 1);
                                                    this.setState({ configdata :data }, () => resolve());
                                                }
                                                resolve();
                                            }, 1000);
                                        }),
                                    }}
                                />
                            </Modal.Body>
                        </Modal>
                    </>
                </Row>
                <Row></Row>
            </Container >
        )
    }
}
