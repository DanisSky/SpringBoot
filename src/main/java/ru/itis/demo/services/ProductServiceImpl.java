package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import ru.itis.demo.dto.ProductDto;
import ru.itis.demo.dto.ProductsPage;
import ru.itis.demo.models.Category;
import ru.itis.demo.models.Product;
import ru.itis.demo.repositories.CategoriesRepository;
import ru.itis.demo.repositories.ProductsRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.List;

import static ru.itis.demo.dto.ProductDto.from;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesRepository categoryRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return from(productsRepository.findAllByIsDeletedIsNull());
    }

    @Override
    public ProductsPage search(Integer size, Integer page, String query, String sortParameter, String directionParameter) {
        Direction direction = Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Product> productsPage = productsRepository.search(query, pageRequest);

        return ProductsPage.builder()
                .pagesCount(productsPage.getTotalPages())
                .products(from(productsPage.getContent()))
                .build();

    }

    @Override
    public ProductDto getProductById(Long id) {
        return from(productsRepository.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    @Override
    public ProductDto addProduct(ProductDto productDto) {
        Product newProduct = Product.builder()
                .name(productDto.getName())
                .pictureUrl(productDto.getPictureUrl())
                .category(categoryRepository.findByName(productDto.getCategory()))
                .created(new Date(Instant.now().getEpochSecond()))
                .updated(new Date(Instant.now().getEpochSecond()))
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .build();

        productsRepository.save(newProduct);

        return from(newProduct);
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto productDto) {
        Product productForUpdate = productsRepository.findById(productId).orElseThrow(IllegalArgumentException::new);
        productForUpdate.setName(productDto.getName());
        productForUpdate.setPictureUrl(productDto.getPictureUrl());
        productForUpdate.setCategory(categoryRepository.findByName(productDto.getCategory()));
        productForUpdate.setUpdated(new Date(Instant.now().getEpochSecond()));
        productForUpdate.setDescription(productDto.getDescription());
        productForUpdate.setPrice(productDto.getPrice());

        return from(productForUpdate);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product productForDelete = productsRepository.findById(productId)
                .orElseThrow(IllegalArgumentException::new);
        productForDelete.setIsDeleted(true);
        productsRepository.save(productForDelete);
    }

    @Override
    public List<ProductDto> getAllProductsByCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return from(productsRepository.findByCategory(category));
    }

    @Override
    public List<ProductDto> getAllProductsByAccountId(Long id) {
        return from(productsRepository.getAllByAccountId(id));
    }

}
