class Hugo { 

    constructor() {
        this.messageState = "a field in js";
    }

    message() { 
        return "good morning";
    }

    get msg() { 
        return "hello property";
    }

    set msg(message) { 
        console.log('hello ' + message);
    }
}

const hugo = new Hugo();
console.log(hugo.message());

const message = hugo.msg;
hugo.msg = "hello from CLI";


