var products = ["TV", "Mobile", "Shoe"];
console.log("To String: " + products.toString());
console.log("Join : " + products.join("-->"));
console.log("Slice : " + products.slice(0, 1));
console.log("Slice : " + products.slice(1, 2));
console.log("Slice : " + products.slice(2, 3));
var arr = ["orange", "mango", "banana", "sugar", "tea"];
var removed = arr.splice(2, 0, "water");
console.log("After adding 1: " + arr);
console.log("removed is: " + removed);
removed = arr.splice(3, 2);
console.log("After removing 1: " + arr);
console.log("removed is: " + removed);
