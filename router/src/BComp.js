class BComp extends HTMLElement { 
    connectedCallback() { 
        this.innerHTML = "b-comp";
    }
    disconnectedCallback() { 
        console.log('not visible');
    }

}

customElements.define('b-comp',BComp);