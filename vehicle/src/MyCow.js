class MyCow extends HTMLElement { 

    constructor() { 
        super();
    }

    connectedCallback() { 
        this.innerHTML = `
            <h2>milk</h2>
            <button>click</button>
        `;
        this.button = this.querySelector("button");
        this.button.onclick = _ => this.buttonClicked();
    }

    buttonClicked() { 
        console.log('clicked');
    }

    disconnectedCallback() { 
        console.log('cleanup');

    }


}
customElements.define('my-cow',MyCow);