// //Ex1
// console.log("Java Script");
// var x = 10;
// x = "Chris";
// x = true;
// console.log(x);

// //Ex2
// function sayHello()
// {
//     for (var i = 0; i < 5; i++)
//     {
//         console.log(i);
//     }
// }
// sayHello();

// //Ex3
// //var vs let
// //Hoisting
// a = 10;
// console.log('Welcome');
// // var a;  //Var is a scope level function.
// let a;  //Let is a scope level block.
// console.log(a);

// //Ex4
// //JSON -> JavaScript Object Notation.
// const emp =
// {
//     name: "Chris",
//     printEmp: function () { },
//     printEmp2()
//     {
//         console.log(this);
//     }
// }

// const emp1 = emp.printEmp2();
// console.log(emp1);

// //Ex5
// //First class object or first class citizens.
// //ES6 standards supports arrow functions (=>).
// const sum = (a, b) => a + b;

// const result = sum(1, 2);
// console.log(result);

// //Ex6
// //Pure Functions
// function add(x, y)
// {
//     return x + y;
// }

// //Impure Functions
// function add(x, y)
// {
//     console.log(x + y); //External dependencies and produces a side effect.
//     return x + y;   //Side effect
// }

// //Ex7
// //First class citizens
// const greet = function (s)
// {
//     return function (name)
//     {
//         return `${s}${name}`
//     };
// }
// const x1 = greet('a1');
// const x2 = greet('a2');
// console.log(x1(" Chris"));
// console.log(x2(" Saran"));

// //Ex8
// const person =
// {
//     name: "Dylan"
// }
// person.lastName = "Lastname";
// console.log(person);

////Immutability (cannot change it)
// const person1 = Object.freeze
// ({
//     firstName: "Justin"
// });
// person1.lastName = "John";
// console.log(person1);

// //Ex9
// const indexes = Object.freeze([0, 1, 2, 3, 4, 5]);
// function addElement(arr)
// {
//     indexes.push(arr.length);
//     return [...arr, arr.length];
// }
// const test = addElement(addElement(indexes);
// console.log(test);

// //Ex10
// //Higher Order Functions
// //A higher order function is a function that receives another function as a paramter
// //or returns a function as a return value.
// const cars = ['Bentley', 'Maseratti', 'Benz', 'Ford'];
// const generic = cars.map((name)=>`Welcome ${name}`);
// console.log(generic);

// //Ex11
// //Composition
// //We can Express as a combination of mult"iple functions to produce a new function.
// const splitName = (name) => name.split("_").join(" ");
// const returnNameUpperCase = (name) => name.toUpperCase();
// console.log(returnNameUpperCase(splitName('Chris_McDaniel')));

//Ex12
// //Spread Parameter
// let veggies = ["Carrot", "Eggplant", "Jalapeno"];
// let [first, second, third] = ["Chilies", ...veggies, "GreenPepper", "Onion"];

// console.log(first);
// console.log(second);
// console.log(third);

// //Ex13
// //Mapping
// let values = [10, 20, 30, 40];
// let double = (n) => n * 2;
// let total = values.map(double);
// console.log(total);

// let total1 = values.filter((n) => n >= 20);
// console.log(total1);

// let result1 = values.reduce((sum, elem) => sum + elem);
// console.log(result1);

// //Ex14
// //Call vs Apply vs Bind => Predefined functions available in JavaScript.
// //Call
// let obj1 = { num: 2 };
// let obj2 = { num: 5 };
// let addToThis = function (a, b, c)
// {
//     return this.num + a + b + c;    //Preferred way of doing this.
//     // return obj1.num + a + b + c; //Not preferred way.
// };
// console.log(addToThis.call(obj2, 2, 3, 4)); //Preferred way of doing this.
// // console.log(addToThis(1, 2, 3)); //Not preferred way.

// //Apply
// let arr = [1, 2, 3];
// console.log(addToThis.apply(obj1, arr));

// //Bind
// let bindTest = addToThis.bind(obj1);
// console.log(bindTest(1, 2, 3));