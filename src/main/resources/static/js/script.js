document.addEventListener('DOMContentLoaded', () => {

    // --- Seletores do DOM ---
    const cadastroForm = document.getElementById('cadastro-form');
    const cadastroFeedback = document.getElementById('cadastro-feedback');
    const addToCartButtons = document.querySelectorAll('.add-to-cart-btn');
    const cartItemsContainer = document.getElementById('cart-items');
    const cartCountSpan = document.getElementById('cart-count');
    const cartTotalSpan = document.getElementById('cart-total');
    const finalizarCompraBtn = document.getElementById('finalizar-compra');

    // --- Variáveis de Estado (Simuladas) ---
    let cart = [];
    let userData = {};

    // --- Funções de Lógica ---

    // Função para renderizar os itens do carrinho
    function renderCart() {
        if (cart.length === 0) {
            cartItemsContainer.innerHTML = '<p>Seu carrinho está vazio.</p>';
            finalizarCompraBtn.disabled = true;
        } else {
            cartItemsContainer.innerHTML = '';
            cart.forEach(item => {
                const cartItemElement = document.createElement('div');
                cartItemElement.classList.add('cart-item');
                cartItemElement.innerHTML = `
                    <div class="cart-item-info">
                        <h4>${item.name}</h4>
                        <p>R$ ${item.price.toFixed(2)}</p>
                    </div>
                    <div class="cart-item-actions">
                        <input type="number" min="1" value="${item.quantity}" data-id="${item.id}" class="quantity-input">
                        <button class="remove-item-btn btn" data-id="${item.id}">Remover</button>
                    </div>
                `;
                cartItemsContainer.appendChild(cartItemElement);
            });
            finalizarCompraBtn.disabled = false;
        }
    }

    // Função para atualizar o total e a contagem do carrinho
    function updateCartSummary() {
        const total = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0);
        const itemCount = cart.reduce((sum, item) => sum + item.quantity, 0);

        cartTotalSpan.textContent = total.toFixed(2);
        cartCountSpan.textContent = itemCount;

        if (itemCount > 0) {
            finalizarCompraBtn.disabled = false;
        } else {
            finalizarCompraBtn.disabled = true;
        }
    }

    // Função para adicionar um item ao carrinho
    function addToCart(product) {
        const existingItem = cart.find(item => item.id === product.id);

        if (existingItem) {
            existingItem.quantity++;
        } else {
            cart.push({
                ...product,
                quantity: 1
            });
        }
        renderCart();
        updateCartSummary();
    }

    // Função para remover um item do carrinho
    function removeFromCart(productId) {
        cart = cart.filter(item => item.id !== productId);
        renderCart();
        updateCartSummary();
    }

    // --- Gerenciamento de Eventos ---

    // Evento de envio do formulário de cadastro
    cadastroForm.addEventListener('submit', (e) => {
        e.preventDefault();
        const formData = new FormData(cadastroForm);
        userData = Object.fromEntries(formData.entries());

        // Simulação de validação e sucesso
        cadastroFeedback.textContent = 'Cadastro realizado com sucesso!';
        cadastroFeedback.classList.add('success');
        cadastroFeedback.classList.remove('error');
    });

    // Evento de clique para adicionar produtos
    addToCartButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            const productCard = e.target.closest('.product-card');
            const product = {
                id: parseInt(productCard.dataset.id),
                name: productCard.dataset.name,
                price: parseFloat(productCard.dataset.price),
            };
            addToCart(product);
        });
    });

    // Eventos para remover itens e atualizar quantidade no carrinho
    cartItemsContainer.addEventListener('click', (e) => {
        if (e.target.classList.contains('remove-item-btn')) {
            const productId = parseInt(e.target.dataset.id);
            removeFromCart(productId);
        }
    });

    cartItemsContainer.addEventListener('change', (e) => {
        if (e.target.classList.contains('quantity-input')) {
            const productId = parseInt(e.target.dataset.id);
            const newQuantity = parseInt(e.target.value);
            const item = cart.find(i => i.id === productId);

            if (item && newQuantity > 0) {
                item.quantity = newQuantity;
                updateCartSummary();
            } else if (item && newQuantity <= 0) {
                removeFromCart(productId);
            }
        }
    });


    // Evento de clique para finalizar a compra via WhatsApp
    finalizarCompraBtn.addEventListener('click', () => {
        if (cart.length === 0 || !userData.nome) {
            alert('Por favor, cadastre-se e adicione itens ao carrinho para finalizar a compra.');
            return;
        }

        let message = `Olá, meu nome é ${userData.nome} e gostaria de fazer o seguinte pedido:\n\n`;

        cart.forEach(item => {
            message += `${item.quantity}x ${item.name} - R$ ${(item.quantity * item.price).toFixed(2)}\n`;
        });

        const total = cart.reduce((sum, item) => sum + (item.price * item.quantity), 0).toFixed(2);
        message += `\nTotal: R$ ${total}\n`;

        message += `\nDados para entrega:\n`;
        message += `Nome: ${userData.nome}\n`;
        message += `Telefone: ${userData.telefone}\n`;
        message += `E-mail: ${userData.email}\n`;
        message += `CPF: ${userData.cpf}\n`;

        const whatsappUrl = `https://wa.me/5511999999999?text=${encodeURIComponent(message)}`;

        // Simula o redirecionamento para o WhatsApp
        window.open(whatsappUrl, '_blank');

        // Limpa o carrinho após a finalização (opcional)
        cart = [];
        renderCart();
        updateCartSummary();
        alert('Seu pedido foi enviado para o WhatsApp! Agradecemos a preferência.');
    });
});