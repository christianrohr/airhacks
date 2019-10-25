class MyCow extends HTMLElement { 

    connectedCallback() { 
        this.innerHTML = `
            <h2>milk</h2>
        `;
    }

}
customElements.define('my-cow',MyCow);