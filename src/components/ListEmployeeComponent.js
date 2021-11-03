import React, {useState} from 'react';

 //creating stateless component
const ListEmployeeComponent = () =>{

    //creating stateful component with Hook
    const  [employees, setEmployees] = useState([]) //function in initial state

    return (
        <div className= "container">
            <h2 className="text-center">List employees</h2>
            <table className="table table-bordered table-striped">
                <thead>
                    <th>Employee Id</th>
                    <th>Employee Firstname</th>
                    <th>Employee Lastname</th>
                    <th>Employee EmailId</th>
                </thead>
                <tbody>
                {
                    employees.map(
                        employee =>
                            <tr key={employee.id}>
                                <td>{employee.id}</td>
                                <td>{employee.firstname}</td>
                                <td>{employee.lastname}</td>
                                <td>{employee.emailId}</td>
                            </tr>
                    )
                }
                </tbody>
            </table>

        </div>
    )
}

export  default ListEmployeeComponent