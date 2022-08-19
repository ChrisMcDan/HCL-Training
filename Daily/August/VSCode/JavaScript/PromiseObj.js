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

function createEmp(newEmp)
{
    return new Promise((resolve, reject) =>
    {
        setTimeout(() =>
        {
            const error = false;

            emps.push(newEmp);

            if (!error)
            {
                resolve();
            }
            else
            {
                reject('Something went wrong!');
            }
        }, 2000);
    })
}

getAllEmps();
createEmp({ ename: 'Ajaydeep', email: 'ajay@gmail.com' })
    .then(getAllEmps)   //Resolve
    .catch((err) => console.log(err));    //Reject



async function displayAllEmps()
{
    await createEmp({ ename: 'Joshua', email: 'joshua@gmail.com' });
    getAllEmps();   //Await until a new employee is created.
}

displayAllEmps();