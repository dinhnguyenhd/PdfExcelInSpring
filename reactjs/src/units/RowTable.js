import React from 'react';

class RowTable extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            code: this.props.row.code,
            name: this.props.row.name,
            address: this.props.row.address,
            taxCode: this.props.row.taxCode,
            email: this.props.row.email,
            mobile: this.props.row.mobile,
            dvtt: this.props.row.dvtt
        }
    }

    
    render() {
        return (
            <tr>
                <td>{this.state.code}</td>
                <td>{this.state.name}</td>
                <td>{this.state.address}</td>
                <td>{this.state.taxCode}</td>
                <td>{this.state.email}</td>
                <td>{this.state.mobile}</td>
                <td>{this.state.dvtt}</td>
            </tr>
        )
    }
}
export default RowTable;