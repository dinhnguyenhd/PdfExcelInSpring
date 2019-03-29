import React, { Component } from 'react';
import { Container, Button, Row } from 'react-bootstrap';
import AudioPlayer from 'react-cl-audio-player';


export default class Home extends Component {
    constructor(props) {
        super(props);
        this.speakMusic = this.speakMusic.bind(this);
        this.state = {
            songs: [
                {
                    url: 'https://static.openfpt.vn/text2speech-v4/male.0.f806c2082db8f5647996de5f44eab10a.mp3',
                    cover: '',
                    artist: {
                        name: 'Goi benh nhan',
                        song: 'Fuel'
                    }
                },

            ]
        }
    }
    speakMusic = () => {
        alert(' hi music ');
        var axios = require('axios');
        var headers = {
            'api_key': '3ac386e3f6a84c8e8df2e246e3ba0527',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept'
        }
        axios.post('http://api.openfpt.vn/text2speech/v4',
            {
                'voice': 'male',
                'data': 'Mời bệnh nhân Nguyễn Thị Phương Mai  đến phòng lấy mẫu !'
            }, { headers: headers })
            .then(function (response) {
                console.log(response.async);

                console.log(response);
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });

    }

    render() {

        return (
            <Container>
                <Row>
                    <ul>
                    <li>Deno chức năng gọi bệnh nhân : </li>
                    <li> + Input : Chuỗi họ và tên :               </li>
                    <li> + Output : Phát chuỗi âm thanh ra loa: Mời bệnh nhân XXX vào phòng khám ! </li>
                    <li> + Solution : </li>
                    <li>Sử dụng API của FPT để convert chuỗi text sang file mp3, rồi sử dụng react-cl-audio-player để play file !</li>
                    </ul>
                </Row>
                <Row>
                    <Button onClick={this.speakMusic} >Play Music !</Button>
                </Row>
                <Row>
                    <AudioPlayer
                        songs={this.state.songs}
                        autoplay
                    />
                </Row>
            </Container>
        )
    }
}
