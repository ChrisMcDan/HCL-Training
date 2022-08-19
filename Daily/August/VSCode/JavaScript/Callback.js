// //Ex1
// console.log('Welcome');
// console.log('To');
// setTimeout(() =>
// {
//     console.log('Call back function fired');
// }, 100/*(n)*/);    //Waits for 'n' milliseconds.

// console.log('the');
// console.log('World of');
// console.log('Asynch JavaScript');

// /*
//     1000s of function.
//     500th function is going to connect to DB.
//     Waiting for the response.
// */

//Ex2
const emps = [
    { ename: 'Chris', email: 'chris@gmail.com' },
    { ename: 'Carlos', email: 'carlos@gmail.com' },
    { ename: 'Saran', email: 'saran@gmail.com' },
    { ename: 'Kemet', email: 'kemet@gmail.com' },
];

function getAllEmps()
{
    setTimeout(() =>
    {
        let result = "";
        emps.forEach((emp, index) =>
        {
            result += `\n${emp.ename}`;
        });
        console.log(result);
    }, 1000);
}

function createEmp(newEmp, callback)
{
    setTimeout(() =>
    {
        emps.push(newEmp);
        callback();
    }, 2000);
}

getAllEmps();   //1000 ms
createEmp({ ename: 'Ajaydeep', email: 'ajay@gmail.com' }, getAllEmps);    //2000 ms

//Ex3
//Intro to Promised Objects.
let promise1 = new Promise(function (resolve, reject)
{
    setTimeout(() => resolve("Success"), 1000);
});

let promise2 = new Promise(function (resolve, reject)
{
    setTimeout(() => reject(new Error("Failure")), 1000);
});