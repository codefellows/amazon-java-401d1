'use strict';

function LinkedList (){
  this.head = null;
  this.tail = null;
}

function Node (value){
  this.value = value;
  this.next = null;
}

LinkedList.prototype.add = function(value){
  if(!this.head){
    this.head = new Node(value);
    this.tail = this.head;
  } else {
    const newNode = new Node(value);
    // If I want O(1) deletion from the end, i need to point everything's next towards the head
    newNode.next = this.tail;
    this.tail = newNode;
    // this.tail.next = newNode;
    // this.tail = newNode;

    // this.tail.next = new Node(value);
    // this.tail = this.tail.next;
  }
}

LinkedList.prototype.removeFromEnd = function(){
  if(!this.head) throw new Error('there was nothing there to begin with');
  if(this.tail.next === null){
    this.head = null;
  }
  this.tail = this.tail.next;
}

LinkedList.prototype.toString = function(){
  let result = '';
  let current = this.tail;
  while(current){
    result = current.value  + ', ' + result;
    current = current.next
  }
  return result;

}

const myList = new LinkedList();
myList.add('first');
myList.add('second');
myList.add('third');

console.log(myList.toString());

myList.removeFromEnd();
myList.removeFromEnd();
myList.removeFromEnd();
myList.removeFromEnd();
myList.removeFromEnd();
myList.removeFromEnd();
myList.removeFromEnd();
console.log(myList);