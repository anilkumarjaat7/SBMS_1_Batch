import { useEffect, useState } from "react";

import ProductForm from "./components/ProductForm";
import ProductList from "./components/ProductList";

import {
  getProducts,
  createProduct,
  updateProduct,
  deleteProduct,
} from "./services/productService";

function App() {
  const [products, setProducts] = useState([]);

  const [editingProduct, setEditingProduct] = useState(null);

  // GET PRODUCTS
  const loadProducts = async () => {
    try {
      const response = await getProducts();

      setProducts(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    loadProducts();
  }, []);

  // CREATE / UPDATE
  const handleSubmit = async (product) => {
    try {
      if (editingProduct) {
        await updateProduct(editingProduct.id, product);

        setEditingProduct(null);
      } else {
        await createProduct(product);
      }

      loadProducts();
    } catch (error) {
      console.log(error);
    }
  };

  // EDIT
  const handleEdit = (product) => {
    setEditingProduct(product);

    window.scrollTo({
      top: 0,
      behavior: "smooth",
    });
  };

  // DELETE
  const handleDelete = async (id) => {
    const confirmDelete = window.confirm("Are you sure you want to delete?");

    if (!confirmDelete) {
      return;
    }

    try {
      await deleteProduct(id);

      loadProducts();
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <header>
        <h1>Product Management</h1>
      </header>

      <ProductForm onSubmit={handleSubmit} editingProduct={editingProduct} />

      <h2 className="list-title">All Products</h2>

      <ProductList
        products={products}
        onEdit={handleEdit}
        onDelete={handleDelete}
      />
    </div>
  );
}

export default App;
