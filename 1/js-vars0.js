//객체표기법
var obj = {a:1, b:2}; //java: new Object(1,2); 이 상태로 이미 객체화됨.
// 배열표기법
var numbers = [1,2]; //java: int[] numbers = {1,2};

//numbers에 재할당을 함. 이 배열에 자료형이 짬뽕임.
//JS 처리시 모두 객체로 취급한다.
numbers = [1,'A',"bb",obj,function(a, b){
  return a+b;
}];
/*
java: Object[] numbers = {1,'A',"bb",obj,function(a, b){
  return a+b;
}}; -->(X)
--> function만큼은 되지 않음. java에서 메소드(함수)는 class안에 존재해야 한다.

java:
Object o = new Calculator() {
  public int add(int a, int b) {
    return a+b;
  }
}
Object[] numbers = {1,'A',"bb",obj,o}; -->(O)
*/

console.log(typeof numbers); //배열도 객체 중 하나.
console.log(Array.isArray(numbers)); //numbers가 배열이 맞는지 확인


for (var i = 0; i < numbers.length; i++) {
  //배열의 요소를 하나씩 꺼내서 그 자료형을 확인.
  switch (typeof numbers[i]) {
    case 'number':
      console.log('숫자');
      break;
    case 'string':
      console.log('문자');
      break;
    case 'object':
      console.log('객체');
      break;
    case 'function':
      // 함수이기 때문에 함수를 호출하고 파라미터를 줘서 함수의 기능의 수행
      console.log('함수', numbers[i](2,3));
      break;
    default:
      console.log('기타');

  }
}
