console.log('hi');

//자료형
//var 변수 선언 시 사용하는 키워드

//number
var n1 = 100;
console.log(typeof n1);
//string
var s1 = 'Hello';
console.log(typeof s1);
//null
var none = null;
console.log(typeof none); //null도 객체다
console.log(none === null); //null 체크는 비교연산자로 한다.
console.log('----------------');
//undefined
var x;
console.log(typeof x);
//object
var obj = {};
console.log(typeof obj);
//function
var add = function add(a, b) {
  return a+b;
};
console.log(typeof add);
//symbol
var sym = Symbol();
console.log(typeof sym);
//boolean
