package com.spring.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.spring.model.Product;
import com.spring.services.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	public ProductService getBookService(){
		return productService;
		
	}
	public ProductService getProductService() {
		return productService;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	@RequestMapping("/getAllProducts")
	public ModelAndView getAllProducts(){
		List<Product> products=productService.getAllProducts();
		return new ModelAndView("productsList","products",products);
	}
	@RequestMapping("/getProductById/{id}")
	public ModelAndView getProductById(@PathVariable(value="id")int id){
		Product b=productService.getProductById(id);
		return new ModelAndView("productPage","productObj",b);
	
	}
	@RequestMapping(value="/addProduct",method=RequestMethod.GET)
	/*public String getProductForm(Model model){
		Product product=new Product();
		Category category=new Category();
		
		category.setCid(1);//necklace //set the category as 1 for the Product product
		product.setCategory(category);
		model.addAttribute("productFromObj",new Product());
		return "productForm";
	}*/
public ModelAndView getProductForm()
{
		ModelAndView model =new ModelAndView("productForm", "productFormObj",new Product() );
		return model;
		
}

	
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addProduct(@Valid @ModelAttribute(value="productFormObj") Product product,BindingResult result)
	{
		if(result.hasErrors())
			return"productForm";
		productService.addProduct(product);
		MultipartFile image = product.getProductImage();
		if(image!=null &&!image.isEmpty()){
			Path path = Paths.get("C:/Users/shiva/workspace/first/src/main/webapp/WEB-INF/resources/images/" +product.getId()+".jpg");
			try{ 
				image.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		return "redirect:getAllProducts";
		
		
}
	@RequestMapping("/editProduct/{id}")
	public ModelAndView getEditForm(@PathVariable(value="id")int id)
	//First read the record which has to be updated
	//select * from PRODUCT where id=?
	//Populate the form with already existing value
	
	{
		Product product=this.productService.getProductById(id);
		return new ModelAndView("editProductForm","editProductObj",product);
	}
	
	@RequestMapping(value="/editProduct",method=RequestMethod.POST)
	public String editProduct(@ModelAttribute(value="editProductObj")Product product)
	{
		productService.editProduct(product);
		return "redirect:/getAllProducts";
	}
	
	
	@RequestMapping(value="/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(value="id")int id){
		Path path=Paths.get("C:/Users/shiva/workspace/first/src/main/webapp/WEB-INF/resources/images/"+id+".jpg");
		if(Files.exists(path))
		{
	           try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
productService.deleteProduct(id);
return "redirect:/getAllProducts";

	}

}


