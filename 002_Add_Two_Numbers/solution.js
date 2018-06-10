
 // Definition for singly-linked list.
function ListNode(val) {
    this.val = val;
    this.next = null;
}

module.exports = {
    createNode: function(strNum){
        var headNode, currNode;
        for(var i = 0; i < strNum.length; i++){
                        var node = new ListNode(Number(strNum.charAt(strNum.length - 1 - i)));
            if(headNode){
                currNode.next = node;
            }else{
                headNode = node;
            }
            currNode      = node;
        }
        return headNode;
    },
    getStrNum: function(l){
        var strNum = "";
        while(l){
            strNum = l.val +strNum;
            l = l.next;
        }
        return strNum;
    },
    addTwoNumbers_1: function(l1, l2){
        var carry = 0;
        var lResult, currentNode;

        while(l1 !== null || l2 !== null){
            var val1, val2, val;
            if(l1){
                val1 = l1.val;
                l1   = l1.next;
            }else{
                val1 = 0;
            }
            if(l2){
                val2 = l2.val;
                l2   = l2.next;
            }else{
                val2 = 0;
            }
            val = val1 + val2 + carry;
            if(val > 9){
                val = val - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            var node = new ListNode(val);
            if(lResult === undefined){ // first node
                lResult = node;
            }else{
                currentNode.next = node;
            }
            currentNode      = node;
        }
        // If carry still hold value
        if(carry > 0){
            var lastNode = new ListNode(carry);
            if(lResult === undefined){ // first node
                lResult = lastNode;
            }else{
                currentNode.next = lastNode;
            }
        }
        return lResult;
    },
    addTwoNumbers_2: function(l1, l2){
        let carry = 0;
        let lResult = new ListNode(0);
        let curNode = lResult;

        while(l1 !== null || l2 !== null || carry > 0){
            let sum = carry;
            if(l1){
                sum += l1.val;
                l1   = l1.next;
            }

            if(l2){
                sum += l2.val;
                l2   = l2.next;
            }

            if(sum > 9){
                sum -= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            curNode.next = new ListNode(sum);
            curNode      = curNode.next;
        }
        return lResult.next;
    }
}
