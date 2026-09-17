function ProductCard({ product, onEdit, onDelete }) {
  return (
    <div className="product-card">
      <img src={product.imageUrl} alt={product.name} />

      <div className="product-info">
        <h2>{product.name}</h2>

        <p>{product.description}</p>

        <h3>₹{product.price}</h3>

        <p>Category: {product.category}</p>

        <p>Brand: {product.brand}</p>

        <p>Stock: {product.stock}</p>

        <div className="buttons">
          <button onClick={() => onEdit(product)}>Edit</button>

          <button onClick={() => onDelete(product.id)}>Delete</button>
        </div>
      </div>
    </div>
  );
}

export default ProductCard;
