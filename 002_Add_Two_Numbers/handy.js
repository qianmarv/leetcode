/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers_2 = function(l1, l2){
    // loop l1 & l2
    var carrier = 0;
    var rootNode = null,
        prevNode = null;
    var fnMakeNode = function(v, pNode){
    }
    while(l1 !== null || l2 !== null || carrier !== 0){
        var v1 = 0,
            v2 = 0;
        if(l1){
            v1 = l1.val;
            l1 = l1.next;
        }
        if(l2){
            v2 = l2.val;
            l2 = l2.next;
        }

        var d = v1 + v2 + carrier;

        if(d > 9){
            d = d % 10;
            carrier = 1;
        }else{
            carrier = 0;
        }
        var cNode = new ListNode(d);
        if(!prevNode){
            prevNode = cNode;
            rootNode = prevNode;
        }else{
            prevNode.next = cNode;
            prevNode= cNode;
        }
    }
    return rootNode;
}


var addTwoNumbers_1 = function(l1, l2) {
    var carrier = 0;
    var val     = 0;
    var exp     = 1;
    while(l1!== null && l2!== null){
       var d = l1.val + l2.val + carrier;
       carrier = 0;
       if(d > 9){
           d = d % 10;
           carrier = 1;
       } 
       val = d*exp + val;
       l1 = l1.next;
       l2 = l2.next;
       exp = exp * 10;
    }
    // Handle left 
    var l = null;
    if(l1 !== null){
        l = l1;
    }else if(l2 !== null){
        l = l2;
    }
    while(l !== null){
        d = l.val + carrier;
        carrier = 0;
       if(d > 9){
           d = d % 10;
           carrier = 1;
       } 
       val = d*exp + val;
       l = l.next;
       exp = exp * 10;
    }
    // Handle carrier
    if(carrier > 0){
        val = carrier * exp + val;
    }
    return val;
};

function ListNode(val) {
     this.val = val;
     this.next = null;
}
function buildList(number) {
    var c = number % 10;
    var n = Math.floor(number / 10);
    var o = new ListNode(c);
    var p = o;

    while( n > 0){
        c = n % 10;
        n = Math.floor(n / 10);
        p.next = new ListNode(c);
        p = p.next;
    }
    return o;
}

// console.log(buildList(103));
var l1 = buildList(999342);
var l2 = buildList(1465);
console.log(addTwoNumbers_1(l1,l2))
console.log(addTwoNumbers_2(l1,l2))