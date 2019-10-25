class TabulatorTable extends HTMLElement { 

    constructor() { 
        super();
        this.root = this.attachShadow({mode:'open'});
        this.data = [
            {name: "duke",language:"java",age:42},
            {name: "brandon",language:"javascript",age:13}
        ];

        this.columns = [
            {title:"Name",field: "name",cellClick: (e,cell) => this.onNameClicked(e,cell._cell)},
            {title:"Programming Language",field: "language"},
            {title: "Age", field: "age", editor: true }
        ];
    }

    connectedCallback() { 
        this.root.innerHTML = `
        <link rel="stylesheet" href="./tabulator/tabulator.css">
            <main id="table"></main>
            <output></output>
        `;
        this.output = this.root.querySelector('output');
        const tabulator = new Tabulator(this.root.querySelector("#table"), {
            layout: "fitColumns",   
            data: this.data,
            columns: this.columns
        });
        console.dir(tabulator)
    }

    onNameClicked(e, cell) { 
        const { value } = cell;
        this.output.innerText = `${value} clicked`;
        console.log('Clicked: ', e, value);
    }
    
}
customElements.define('tabulator-table',TabulatorTable);