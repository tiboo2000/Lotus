import React from 'react';
import axios from 'axios';
import './bag.css';

class Bag extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      data: null,
      temp: [],
      temp2: [],
      tempname: [],
      tempQuantity: [],
      allproduct:[],
      productidandquantity:[],
      intfullprice : [],
    };
  }

  componentDidMount() {
    this.fetchData();
  }
  
  

  fetchData = async () => {
    const result = await axios('http://localhost:9090/bag?user=test');
    var tempprice = 0;
    result.data.listProduct.map((product) => {
        tempprice = tempprice + product.price
        this.state.allproduct.push(product)
        if (!this.state.temp.includes(product.id)){
            this.state.temp.push(product.id)
            this.state.temp2.push(product)
            this.state.tempname.push("test")//rechercher le nom de l'utilisateur dans le props pour swap d'uitilisateur et dans la requete aussi du coup
        }
    });
    this.state.allproduct.forEach((element) => {
        if (this.state.productidandquantity.includes(element.id)){
            this.state.productidandquantity[this.state.productidandquantity.indexOf(element.id) + 1] = this.state.productidandquantity[this.state.productidandquantity.indexOf(element.id) + 1] + 1
        }
        else{
            this.state.productidandquantity.push(element.id)
            this.state.productidandquantity.push(1)
        }
    });
    this.state.intfullprice.push(tempprice);
    this.setState({ data: this.state.temp2});
    //const result2 = await axios('http://localhost:9090/bag/getquantity?id=1&name=test&price=1&categoryid=1&nameuser=test');
}; 


    deleteProduct = async (nameuser, product) => {
        try {
            const response = await axios.delete('http://localhost:9090/bag/delete/product', {
                params: { nameuser },
                data: product
            });
        } catch (error) {
            console.error('Failed to delete product:', error);
        }
    };

    addinbagtest() {
        axios.post('http://localhost:9090/bag/add',
                {id: 1,
                name: 'test',
                price: 1.0,
                categoryId: 1},
                 {
                params: {
                    nameuser: "test"
                }
        })
    }
    getfullprice() {
        let sum = 0;
        document.querySelectorAll('.price').forEach((priceElement) => {
            console.log(priceElement.textContent);
            const price = parseFloat(priceElement.textContent);
            sum += parseInt(price);
        });
        return sum;
    }

    changeQuantity(product,user,newquantity){
        try {
            axios.put('http://localhost:9090/bag/update',
                    {
                    id: product.id,
                    name: product.name,
                    price: product.price,
                    categoryId: product.categoryId
                    },
                    {
                    params: {
                        nameuser: user,//changer le nom de l'utilisateur
                        quantity: newquantity,
                        operation: "set"
                    }
            })
            }
        catch (error) {
            console.error('Failed change quantity product:', error);
        }
    }

  render() {
    const { data } = this.state;
    return (
        <div>     
        <div className="shopping-cart">
        <h1>Shopping Cart</h1>
        <div className="products">
            {Array.isArray(data) && data.map((product) => (
                <div key={product.id} className="product">
                    <div className="product-info">
                        <p>{product.name}</p>
                        <p>ID: {product.id}</p>
                        <p>Category: {product.categoryId}</p>
                    </div>
                    <div className="product-price">
                        <p>${product.price}</p>
                    </div>
                    <div className="product-quantity">                                                                          
                        <input type="number" onChange={(e) => { if(e.target.value!="" || e.target.value >0 )this.changeQuantity({id: product.id,name: product.name /*changer*/,price: product.price,categoryId: product.categoryId}, "test", e.target.value)}} defaultValue={this.state.productidandquantity[this.state.productidandquantity.indexOf(product.id) + 1]} />
                    </div>
                    <div className="product-total">
                        <p className='price'>${product.price * this.state.productidandquantity[this.state.productidandquantity.indexOf(product.id) + 1]}</p>
                    </div>
                    <button onClick={() => this.deleteProduct("test", product)}>Remove</button>
                </div>
            ))
            }
        </div>
        <div className="subtotal">
            <h2>Subtotal</h2>
            <p>{this.state.intfullprice + '€'}</p>
        </div>
        <button>Proceed to Checkout</button>
        </div>
        </div>
    );  
    }
}

export default Bag;