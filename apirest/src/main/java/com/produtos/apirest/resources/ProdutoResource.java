package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.produtoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	produtoRepository produtoRepository;
	
	
	@GetMapping("/produtos")
	@ApiOperation(value="retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produtos/{id}")
	@ApiOperation(value="retorna um produto pelo id")
	public Produto listaProdutoUnico( @PathVariable(value="id")long id){
		return produtoRepository.findById(id);
	}
	
	@PostMapping("/produtos")
	@ApiOperation(value="esse metodo salva o produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produtos")
	@ApiOperation(value="esse metodo deleta o produto")
	public void delatarProduto( @RequestBody Produto produto){
		 	produtoRepository.delete(produto);
	}
	
	@PutMapping("/produtos")
	@ApiOperation(value="esse metodo atualiza o produto")
	public Produto AlterarProduto( @RequestBody Produto produto){
		 return produtoRepository.save(produto);
	}
	
}
