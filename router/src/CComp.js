class CComp  extends HTMLElement { 
    connectedCallback() { 
        this.innerHTML = `c-comp ${this.location.params.id}`;
    }
    disconnectedCallback() { 
        console.log('not visible');
    }

}

customElements.define('c-comp',CComp);