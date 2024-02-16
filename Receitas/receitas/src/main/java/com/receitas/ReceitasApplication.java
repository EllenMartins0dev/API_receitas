package com.receitas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.receitas.Enum.CategoriaEnum;
import com.receitas.Enum.DificuldadeEnum;
import com.receitas.Repositories.ReceitaRepository;
import com.receitas.model.EtapaPreparo;
import com.receitas.model.Ingrediente;
import com.receitas.model.Receita;

@SpringBootApplication
public class ReceitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitasApplication.class, args);
	}

	@Bean
	CommandLineRunner criarReceitasFake(ReceitaRepository rp) {
		return args -> {

			rp.deleteAll();

			// Bife à parmegiana
			Ingrediente bife = new Ingrediente();
			bife.setNome(("Bife"));
			bife.setUnidadeMedida("Kg");
			bife.setQuantidade(5);

			Ingrediente molho = new Ingrediente();
			molho.setNome("Molho de tomate");
			molho.setUnidadeMedida("Unidade");
			molho.setQuantidade(2);

			Ingrediente trigo = new Ingrediente();
			trigo.setNome("Farinha de trigo");
			trigo.setUnidadeMedida("Xícara");
			trigo.setQuantidade(2);

			Ingrediente ovo = new Ingrediente();
			ovo.setNome("Ovo de galinha");
			ovo.setUnidadeMedida("Unidade");
			ovo.setQuantidade(2);

			Ingrediente farinha = new Ingrediente();
			farinha.setNome("Farinha Panco");
			farinha.setUnidadeMedida("Xícara");
			farinha.setQuantidade(2);

			Ingrediente queijo = new Ingrediente();
			queijo.setNome("Queijo mussarela");
			queijo.setUnidadeMedida("Gramas");
			queijo.setQuantidade(200);

			Ingrediente oleo = new Ingrediente();
			oleo.setNome("Óleo de soja");
			oleo.setUnidadeMedida("Litros");
			oleo.setQuantidade(0.2);

			Ingrediente sal = new Ingrediente();
			sal.setNome("Sal fino");
			sal.setUnidadeMedida("Kg");
			sal.setQuantidade(0);

			Ingrediente pimenta = new Ingrediente();
			pimenta.setNome("Pimenta do reino");
			bife.setUnidadeMedida("Gramas");
			bife.setQuantidade(0);

			// Etapas de preparo - Bife
			EtapaPreparo temperar = new EtapaPreparo();
			temperar.setDescricao("Temperar o bife com sal e pimenta");

			EtapaPreparo empanar = new EtapaPreparo();
			empanar.setDescricao("Passar o bife na farinha de trigo, depois no ovo e finalmente na farinha de rosca");

			EtapaPreparo fritar = new EtapaPreparo();
			fritar.setDescricao("Aquecer o óleo em uma panela e fritar o bife até ele ficar douradinho");

			EtapaPreparo gratinar = new EtapaPreparo();
			gratinar.setDescricao(
					"Colocar em uma forma, adicoonar o molho, queijo mussarela e levar ao forno. Aquecer em 180°C até o ponto de sua preferência");

			Receita bifeParmegiana = new Receita();
			bifeParmegiana.setNome("Bife a parmegiana");
			bifeParmegiana.setCategoria(CategoriaEnum.SALGADOS);
			bifeParmegiana.setDificuldade(DificuldadeEnum.FACIL);
			bifeParmegiana.setRendimento("Uma porção por pessoa");
			bifeParmegiana.setAutor("Victor Sabatin");
			bifeParmegiana.setDescricao("Bife à parmegiana muito saboroso para tornar sua refeição uma experiência deliciosa");
			bifeParmegiana.setTempoDePreparo(10);
			bifeParmegiana.setObservacao("Esta receita é muito saborosa. Tempere a gosto.");


			// Ingredientes - Bife 
			List<EtapaPreparo> etapas = new ArrayList<>();
			etapas.add(temperar);
			etapas.add(empanar);
			etapas.add(fritar);
			etapas.add(gratinar);

			List<Ingrediente> ingredientes = new ArrayList<>();
			ingredientes.add(pimenta);
			ingredientes.add(ovo);
			ingredientes.add(oleo);
			ingredientes.add(trigo);
			ingredientes.add(farinha);
			ingredientes.add(bife);
			ingredientes.add(molho);
			ingredientes.add(queijo);
			ingredientes.add(sal);

			bifeParmegiana.setEtapasPreparo(etapas);
			bifeParmegiana.setIngredientes(ingredientes);


			//Salvar - Bife
			rp.save(bifeParmegiana);


			// Strogonoff
			Ingrediente frango = new Ingrediente();
			frango.setNome("Frango");
			frango.setUnidadeMedida("Kg");
			frango.setQuantidade(1);

			Ingrediente cremeDeLeite = new Ingrediente();
			cremeDeLeite.setNome("Creme de leite");
			cremeDeLeite.setUnidadeMedida("Lata");
			cremeDeLeite.setQuantidade(1);

			Ingrediente champignon = new Ingrediente();
			champignon.setNome("Champignon");
			champignon.setUnidadeMedida("Gramas");
			champignon.setQuantidade(200);


			//Etapa de preparo - Strogonoff
			EtapaPreparo cortarFrango = new EtapaPreparo();
			cortarFrango.setDescricao("Cortar o frango em cubos");

			EtapaPreparo refogarFrango = new EtapaPreparo();
			refogarFrango.setDescricao("Refogar o frango com alho e cebola");

			EtapaPreparo adicionarCreme = new EtapaPreparo();
			adicionarCreme.setDescricao("Adicionar o creme de leite e o champignon");

			Receita strogonoffFrango = new Receita();
			strogonoffFrango.setNome("Strogonoff de Frango");
			strogonoffFrango.setCategoria(CategoriaEnum.SALGADOS);
			strogonoffFrango.setDificuldade(DificuldadeEnum.MEDIO);
			strogonoffFrango.setRendimento("Serve 4 pessoas");
			strogonoffFrango.setAutor("Rafaela Bastos");
			strogonoffFrango.setDescricao("Uma deliciosa versão do clássico strogonoff com frango");
			strogonoffFrango.setTempoDePreparo(30);
			strogonoffFrango.setObservacao("Sirva com arroz branco e batata palha.");


			// Lista ingredientes - Strogonoff
			List<EtapaPreparo> etapasStrogonoffFrango = new ArrayList<>();
			etapasStrogonoffFrango.add(cortarFrango);
			etapasStrogonoffFrango.add(refogarFrango);
			etapasStrogonoffFrango.add(adicionarCreme);

			strogonoffFrango.setEtapasPreparo(etapasStrogonoffFrango);

			List<Ingrediente> ingredientesStrogonoffFrango = new ArrayList<>();
			ingredientesStrogonoffFrango.add(frango);
			ingredientesStrogonoffFrango.add(cremeDeLeite);
			ingredientesStrogonoffFrango.add(champignon);

			strogonoffFrango.setIngredientes(ingredientesStrogonoffFrango);


			//Salvar - Strogonoff
			rp.save(strogonoffFrango);


			// Lasanha de Carne
			Ingrediente carneMoida = new Ingrediente();
			carneMoida.setNome("Carne moída");
			carneMoida.setUnidadeMedida("Kg");
			carneMoida.setQuantidade(0.5);

			Ingrediente molhoTomate = new Ingrediente();
			molhoTomate.setNome("Molho de tomate");
			molhoTomate.setUnidadeMedida("Lata");
			molhoTomate.setQuantidade(2);

			Ingrediente queijoParmesao = new Ingrediente();
			queijoParmesao.setNome("Queijo parmesão ralado");
			queijoParmesao.setUnidadeMedida("Gramas");
			queijoParmesao.setQuantidade(100);

			Ingrediente massaLasanha = new Ingrediente();
			massaLasanha.setNome("Massa para lasanha");
			massaLasanha.setUnidadeMedida("pacote");
			massaLasanha.setQuantidade(1);


			// Etapa de preparo - Lasanha
			EtapaPreparo cozinharCarne = new EtapaPreparo();
			cozinharCarne.setDescricao("Cozinhar a carne moída com temperos");

			EtapaPreparo montarLasanha = new EtapaPreparo();
			montarLasanha.setDescricao("Montar a lasanha em camadas alternadas de massa, molho e queijo");

			EtapaPreparo assarLasanha = new EtapaPreparo();
			assarLasanha.setDescricao("Levar ao forno para assar até que o queijo derreta e fique dourado");

			Receita lasanhaCarne = new Receita();
			lasanhaCarne.setNome("Lasanha de Carne");
			lasanhaCarne.setCategoria(CategoriaEnum.SALGADOS);
			lasanhaCarne.setDificuldade(DificuldadeEnum.DIFICIL);
			lasanhaCarne.setRendimento("Serve 6 pessoas");
			lasanhaCarne.setAutor("Ana Rogéria Costa");
			lasanhaCarne.setDescricao("Uma deliciosa lasanha caseira feita com carne moída e molho de tomate");
			lasanhaCarne.setTempoDePreparo(60);
			lasanhaCarne.setObservacao("Sirva com uma salada verde.");


			//Lista ingredientes - Lasanha
			List<EtapaPreparo> etapasLasanhaCarne = new ArrayList<>();
			etapasLasanhaCarne.add(cozinharCarne);
			etapasLasanhaCarne.add(montarLasanha);
			etapasLasanhaCarne.add(assarLasanha);

			lasanhaCarne.setEtapasPreparo(etapasLasanhaCarne);

			List<Ingrediente> ingredientesLasanhaCarne = new ArrayList<>();
			ingredientesLasanhaCarne.add(carneMoida);
			ingredientesLasanhaCarne.add(molhoTomate);
			ingredientesLasanhaCarne.add(queijoParmesao);

			lasanhaCarne.setIngredientes(ingredientesLasanhaCarne);
			lasanhaCarne.setObservacao("Temperar à gosto.");


			// Salvar - Lasanha 
			rp.save(lasanhaCarne);


			// Bolo de chocolate
			Ingrediente chocolateEmPo = new Ingrediente();
			chocolateEmPo.setNome("Chocolate em pó");
			chocolateEmPo.setUnidadeMedida("Xícara");
			chocolateEmPo.setQuantidade(1);

			Ingrediente acucar = new Ingrediente();
			acucar.setNome("Açúcar");
			acucar.setUnidadeMedida("Xícara");
			acucar.setQuantidade(1);

			Ingrediente farinhaTrigo = new Ingrediente();
			farinhaTrigo.setNome("Farinha de trigo");
			farinhaTrigo.setUnidadeMedida("Xícara");
			farinhaTrigo.setQuantidade(2);

			Ingrediente ovos = new Ingrediente();
			ovos.setNome("Ovos");
			ovos.setUnidadeMedida("Unidade");
			ovos.setQuantidade(3);


			// Etapa de preparo - Bolo de chocolate
			EtapaPreparo misturarIngredientesSecos = new EtapaPreparo();
			misturarIngredientesSecos.setDescricao("Misturar o chocolate em pó, o açúcar e a farinha de trigo em uma tigela");

			EtapaPreparo baterOvos = new EtapaPreparo();
			baterOvos.setDescricao("Bater os ovos em outra tigela");

			EtapaPreparo juntarIngredientes = new EtapaPreparo();
			juntarIngredientes.setDescricao("Juntar os ovos batidos aos ingredientes secos e misturar bem até formar uma massa homogênea");

			Receita boloChocolate = new Receita();
			boloChocolate.setNome("Bolo de Chocolate");
			boloChocolate.setCategoria(CategoriaEnum.DOCES);
			boloChocolate.setDificuldade(DificuldadeEnum.FACIL);
			boloChocolate.setRendimento("Serve 8 pessoas");
			boloChocolate.setAutor("Julia Ferreira");
			boloChocolate.setDescricao("Um delicioso bolo de chocolate para satisfazer os amantes de doces");
			boloChocolate.setTempoDePreparo(45);
			boloChocolate.setObservacao("Sirva com uma bola de sorvete de creme.");


			//Lista ingredientes - Bolo de chocolate
			List<EtapaPreparo> etapasBoloChocolate = new ArrayList<>();
			etapasBoloChocolate.add(misturarIngredientesSecos);
			etapasBoloChocolate.add(baterOvos);
			etapasBoloChocolate.add(juntarIngredientes);

			boloChocolate.setEtapasPreparo(etapasBoloChocolate);

			List<Ingrediente> ingredientesBoloChocolate = new ArrayList<>();
			ingredientesBoloChocolate.add(chocolateEmPo);
			ingredientesBoloChocolate.add(acucar);
			ingredientesBoloChocolate.add(farinhaTrigo);
			ingredientesBoloChocolate.add(ovos);

			boloChocolate.setIngredientes(ingredientesBoloChocolate);


			//Salvar - Bolo de chocolate
			rp.save(boloChocolate);


			//Torta de Limão
			Ingrediente bolachaMaisena = new Ingrediente();
			bolachaMaisena.setNome("Bolacha maisena");
			bolachaMaisena.setUnidadeMedida("Pacote");
			bolachaMaisena.setQuantidade(1);

			Ingrediente manteiga = new Ingrediente();
			manteiga.setNome("Manteiga");
			manteiga.setUnidadeMedida("Colher de sopa");
			manteiga.setQuantidade(4);

			Ingrediente leiteCondensado = new Ingrediente();
			leiteCondensado.setNome("Leite condensado");
			leiteCondensado.setUnidadeMedida("Lata");
			leiteCondensado.setQuantidade(1);

			Ingrediente sucoLimao = new Ingrediente();
			sucoLimao.setNome("Suco de limão");
			sucoLimao.setUnidadeMedida("Xícara");
			sucoLimao.setQuantidade(1);


			//Etapas de preparo - Torta de limão
			EtapaPreparo triturarBolachas = new EtapaPreparo();
			triturarBolachas.setDescricao("Triturar as bolachas maisena até formar uma farofa");

			EtapaPreparo derreterManteiga = new EtapaPreparo();
			derreterManteiga.setDescricao("Derreter a manteiga e misturar com a farofa de bolachas");

			EtapaPreparo forrarForma = new EtapaPreparo();
			forrarForma.setDescricao("Forrar o fundo de uma forma com a mistura de bolachas e manteiga");

			EtapaPreparo prepararCremeLimao = new EtapaPreparo();
			prepararCremeLimao
					.setDescricao("Preparar o creme de limão misturando o leite condensado com o suco de limão");

			Receita tortaLimao = new Receita();
			tortaLimao.setNome("Torta de Limão");
			tortaLimao.setCategoria(CategoriaEnum.DOCES);
			tortaLimao.setDificuldade(DificuldadeEnum.FACIL);
			tortaLimao.setRendimento("Serve 10 pessoas");
			tortaLimao.setAutor("Carlos Eduardo Pereira");
			tortaLimao.setDescricao("Uma deliciosa torta de limão com base de bolacha maisena");
			tortaLimao.setTempoDePreparo(60);
			tortaLimao.setObservacao("Sirva gelado.");


			
			List<EtapaPreparo> etapasTortaLimao = new ArrayList<>();
			etapasTortaLimao.add(triturarBolachas);
			etapasTortaLimao.add(derreterManteiga);
			etapasTortaLimao.add(forrarForma);
			etapasTortaLimao.add(prepararCremeLimao);

			tortaLimao.setEtapasPreparo(etapasTortaLimao);


			//Lista ingredientes - Torta de limão
			List<Ingrediente> ingredientesTortaLimao = new ArrayList<>();
			ingredientesTortaLimao.add(bolachaMaisena);
			ingredientesTortaLimao.add(manteiga);
			ingredientesTortaLimao.add(leiteCondensado);
			ingredientesTortaLimao.add(sucoLimao);

			tortaLimao.setIngredientes(ingredientesTortaLimao);

			// Salvar - Torta de limão
			rp.save(tortaLimao);


			// Risote de Cogumelos
			Ingrediente arrozArboreo = new Ingrediente();
			arrozArboreo.setNome("Arroz arbóreo");
			arrozArboreo.setUnidadeMedida("Xícara");
			arrozArboreo.setQuantidade(2);

			Ingrediente cogumelos = new Ingrediente();
			cogumelos.setNome("Cogumelos frescos");
			cogumelos.setUnidadeMedida("Gramas");
			cogumelos.setQuantidade(200);

			Ingrediente cebola = new Ingrediente();
			cebola.setNome("Cebola");
			cebola.setUnidadeMedida("Unidade");
			cebola.setQuantidade(1);

			Ingrediente alho = new Ingrediente();
			alho.setNome("Alho");
			alho.setUnidadeMedida("Dente");
			alho.setQuantidade(2);

			Ingrediente caldoLegumes = new Ingrediente();
			caldoLegumes.setNome("Caldo de legumes");
			caldoLegumes.setUnidadeMedida("Tablete");
			caldoLegumes.setQuantidade(1);

			Ingrediente vinhoBranco = new Ingrediente();
			vinhoBranco.setNome("Vinho branco seco");
			vinhoBranco.setUnidadeMedida("Xícara");
			vinhoBranco.setQuantidade(1);

			Ingrediente azeite = new Ingrediente();
			azeite.setNome("Azeite de oliva");
			azeite.setUnidadeMedida("Colher de sopa");
			azeite.setQuantidade(2);


			// Etas preparo - Risoto de cogumelos
			EtapaPreparo prepararCaldoLegumes = new EtapaPreparo();
			prepararCaldoLegumes.setDescricao("Dissolver o caldo de legumes em água quente e manter aquecido");

			EtapaPreparo refogarCebolaAlho = new EtapaPreparo();
			refogarCebolaAlho.setDescricao("Refogar a cebola e o alho no azeite até ficarem dourados");

			EtapaPreparo adicionarArroz = new EtapaPreparo();
			adicionarArroz.setDescricao("Adicionar o arroz arbóreo ao refogado e mexer até ficar bem envolvido no azeite");

			Receita risotoCogumelos = new Receita();
			risotoCogumelos.setNome("Risoto de Cogumelos");
			risotoCogumelos.setCategoria(CategoriaEnum.VEGETARIANO);
			risotoCogumelos.setDificuldade(DificuldadeEnum.MEDIO);
			risotoCogumelos.setRendimento("Serve 4 pessoas");
			risotoCogumelos.setAutor("Antônio Fasgundes");
			risotoCogumelos.setDescricao("Um delicioso risoto vegetariano feito com cogumelos frescos e arroz arbóreo");
			risotoCogumelos.setTempoDePreparo(40);
			risotoCogumelos.setObservacao("Sirva quente com queijo parmesão ralado por cima.");

			List<EtapaPreparo> etapasRisotoCogumelos = new ArrayList<>();
			etapasRisotoCogumelos.add(prepararCaldoLegumes);
			etapasRisotoCogumelos.add(refogarCebolaAlho);
			etapasRisotoCogumelos.add(adicionarArroz);

			risotoCogumelos.setEtapasPreparo(etapasRisotoCogumelos);

			
			// Lista ingredientes - Risoto de cogumelos
			List<Ingrediente> ingredientesRisotoCogumelos = new ArrayList<>();
			ingredientesRisotoCogumelos.add(arrozArboreo);
			ingredientesRisotoCogumelos.add(cogumelos);
			ingredientesRisotoCogumelos.add(cebola);
			ingredientesRisotoCogumelos.add(alho);
			ingredientesRisotoCogumelos.add(caldoLegumes);
			ingredientesRisotoCogumelos.add(vinhoBranco);
			ingredientesRisotoCogumelos.add(azeite);
			ingredientesRisotoCogumelos.add(queijoParmesao);

			risotoCogumelos.setIngredientes(ingredientesRisotoCogumelos);
			risotoCogumelos.setObservacao("Temperar à gosto.");

			
			// Salvar - Risoto de cogumelo
			rp.save(risotoCogumelos);


			//Espaguete de abobrinha
			Ingrediente abobrinha = new Ingrediente();
			abobrinha.setNome("Abobrinha");
			abobrinha.setUnidadeMedida("Unidade");
			abobrinha.setQuantidade(2);

			Ingrediente tomate = new Ingrediente();
			tomate.setNome("Tomate");
			tomate.setUnidadeMedida("Unidade");
			tomate.setQuantidade(4);

			Ingrediente manjericao = new Ingrediente();
			manjericao.setNome("Manjericão");
			manjericao.setUnidadeMedida("Folhas");
			manjericao.setQuantidade(10);

			Ingrediente macarraoIntegral = new Ingrediente();
			macarraoIntegral.setNome("Macarrão integral");
			macarraoIntegral.setUnidadeMedida("Pacote");
			macarraoIntegral.setQuantidade(1);


			// Etapas preparo - Espaguete abobrinha
			EtapaPreparo prepararMacarrao = new EtapaPreparo();
			prepararMacarrao.setDescricao("Cozinhar o macarrão integral conforme instruções da embalagem e reservar");

			EtapaPreparo refogarLegumes = new EtapaPreparo();
			refogarLegumes.setDescricao("Refogar a cebola e o alho no azeite até dourar, adicionar os tomates picados e refogar até formar um molho, adicionar a abobrinha cortada em fatias finas e refogar até ficar macia");

			EtapaPreparo finalizarEspaguete = new EtapaPreparo();
			finalizarEspaguete.setDescricao("Adicionar o macarrão integral cozido ao molho de tomate e abobrinha, temperar com sal e pimenta a gosto, finalizar com folhas de manjericão fresco");

			Receita espagueteAbobrinha = new Receita();
			espagueteAbobrinha.setNome("Espaguete de Abobrinha Vegano");
			espagueteAbobrinha.setCategoria(CategoriaEnum.VEGANO);
			espagueteAbobrinha.setDificuldade(DificuldadeEnum.MEDIO);
			espagueteAbobrinha.setRendimento("Serve 4 pessoas");
			espagueteAbobrinha.setAutor("Cláudio Lins");
			espagueteAbobrinha.setDescricao("Uma deliciosa opção de espaguete vegano feito com abobrinha e molho de tomate fresco");
			espagueteAbobrinha.setTempoDePreparo(30);
			espagueteAbobrinha.setObservacao("Sirva quente e aproveite!");

			List<EtapaPreparo> etapasEspagueteAbobrinha = new ArrayList<>();
			etapasEspagueteAbobrinha.add(prepararMacarrao);
			etapasEspagueteAbobrinha.add(refogarLegumes);
			etapasEspagueteAbobrinha.add(finalizarEspaguete);

			espagueteAbobrinha.setEtapasPreparo(etapasEspagueteAbobrinha);


			// Lista ingredientes - Espaguete abobrinha
			List<Ingrediente> ingredientesEspagueteAbobrinha = new ArrayList<>();
			ingredientesEspagueteAbobrinha.add(abobrinha);
			ingredientesEspagueteAbobrinha.add(tomate);
			ingredientesEspagueteAbobrinha.add(alho);
			ingredientesEspagueteAbobrinha.add(cebola);
			ingredientesEspagueteAbobrinha.add(azeite);
			ingredientesEspagueteAbobrinha.add(manjericao);
			ingredientesEspagueteAbobrinha.add(sal);
			ingredientesEspagueteAbobrinha.add(pimenta);
			ingredientesEspagueteAbobrinha.add(macarraoIntegral);

			espagueteAbobrinha.setIngredientes(ingredientesEspagueteAbobrinha);


			// Salvar - Espaguete abobrinha
			rp.save(espagueteAbobrinha);


			// Espaguete Abobrinha Pesto
			Ingrediente pesto = new Ingrediente();
			pesto.setNome("Molho Pesto");
			pesto.setUnidadeMedida("Xícara");
			pesto.setQuantidade(1);

			Ingrediente espaguete = new Ingrediente();
			espaguete.setNome("Espaguete Integral");
			espaguete.setUnidadeMedida("Gramas");
			espaguete.setQuantidade(300);

			Ingrediente castanha = new Ingrediente();
			castanha.setNome("Castanha-de-caju");
			castanha.setUnidadeMedida("Colher de sopa");
			castanha.setQuantidade(2);


			// Etapas preparo - Espaguete abobrinha pesto
			EtapaPreparo prepararPesto = new EtapaPreparo();
			prepararPesto.setDescricao("Preparar o molho pesto batendo o alho, azeite, castanha, queijo e sal em um processador");

			EtapaPreparo cortarAbobrinha = new EtapaPreparo();
			cortarAbobrinha.setDescricao("Cortar as abobrinhas em tiras finas ou usar um espiralizador");

			EtapaPreparo cozinharEspaguete = new EtapaPreparo();
			cozinharEspaguete.setDescricao("Cozinhar o espaguete integral em água fervente até ficar al dente");

			EtapaPreparo misturarIngredientes = new EtapaPreparo();
			misturarIngredientes.setDescricao("Em uma panela grande, misturar o espaguete cozido, as tiras de abobrinha e o molho pesto até aquecer bem");

			Receita espagueteAbobrinhaPesto = new Receita();
			espagueteAbobrinhaPesto.setNome("Espaguete de Abobrinha ao Pesto Vegetariano");
			espagueteAbobrinhaPesto.setCategoria(CategoriaEnum.VEGETARIANO);
			espagueteAbobrinhaPesto.setDificuldade(DificuldadeEnum.DIFICIL);
			espagueteAbobrinhaPesto.setRendimento("Serve 4 pessoas");
			espagueteAbobrinhaPesto.setAutor("Victor Sabatin");
			espagueteAbobrinhaPesto.setDescricao("Uma alternativa leve e saborosa ao espaguete tradicional, feita com abobrinha e molho pesto caseiro");
			espagueteAbobrinhaPesto.setTempoDePreparo(30);
			espagueteAbobrinhaPesto.setObservacao("Sirva quente e aproveite!");

			List<EtapaPreparo> etapasEspagueteAbobrinhaPesto = new ArrayList<>();
			etapasEspagueteAbobrinhaPesto.add(prepararPesto);
			etapasEspagueteAbobrinhaPesto.add(cortarAbobrinha);
			etapasEspagueteAbobrinhaPesto.add(cozinharEspaguete);
			etapasEspagueteAbobrinhaPesto.add(misturarIngredientes);

			espagueteAbobrinhaPesto.setEtapasPreparo(etapasEspagueteAbobrinhaPesto);


			// Lista ingredientes - Espaguete abobrinha pesto
			List<Ingrediente> ingredientesEspagueteAbobrinhaPesto = new ArrayList<>();
			ingredientesEspagueteAbobrinhaPesto.add(abobrinha);
			ingredientesEspagueteAbobrinhaPesto.add(pesto);
			ingredientesEspagueteAbobrinhaPesto.add(espaguete);
			ingredientesEspagueteAbobrinhaPesto.add(alho);
			ingredientesEspagueteAbobrinhaPesto.add(oleo);
			ingredientesEspagueteAbobrinhaPesto.add(castanha);
			ingredientesEspagueteAbobrinhaPesto.add(queijo);
			ingredientesEspagueteAbobrinhaPesto.add(sal);
			ingredientesEspagueteAbobrinhaPesto.add(pimenta);

			espagueteAbobrinhaPesto.setIngredientes(ingredientesEspagueteAbobrinhaPesto);
			espagueteAbobrinha.setObservacao("Temperar à gosto.");


			// Salvar - Espaguete abobrinha pesto
			rp.save(espagueteAbobrinhaPesto);


			// Frango Legumes Low Carb 
			Ingrediente peitoFrango = new Ingrediente();
			peitoFrango.setNome("Peito de Frango");
			peitoFrango.setUnidadeMedida("Gramas");
			peitoFrango.setQuantidade(500);

			Ingrediente brócolis = new Ingrediente();
			brócolis.setNome("Brócolis");
			brócolis.setUnidadeMedida("Gramas");
			brócolis.setQuantidade(300);


			// Etapas de preparo - Frango legumes low carb 
			EtapaPreparo prepararFrango = new EtapaPreparo();
			prepararFrango.setDescricao("Temperar o peito de frango com alho, sal e pimenta a gosto e reservar");

			EtapaPreparo prepararLegumes = new EtapaPreparo();
			prepararLegumes.setDescricao("Cortar os brócolis, abobrinha e cebola em pedaços médios e temperar com sal, azeite e pimenta");

			EtapaPreparo assar = new EtapaPreparo();
			assar.setDescricao("Dispor o frango e os legumes em uma assadeira, regar com um fio de azeite e assar em forno preaquecido a 180°C por aproximadamente 30 minutos ou até dourar");

			Receita frangoLegumesLowCarb = new Receita();
			frangoLegumesLowCarb.setNome("Frango com Legumes Assados Low Carb");
			frangoLegumesLowCarb.setCategoria(CategoriaEnum.LOW_CARB);
			frangoLegumesLowCarb.setDificuldade(DificuldadeEnum.MEDIO);
			frangoLegumesLowCarb.setRendimento("Serve 4 pessoas");
			frangoLegumesLowCarb.setAutor("Regina Pires");
			frangoLegumesLowCarb.setDescricao("Uma opção deliciosa e saudável para uma refeição low carb, rica em proteínas e vegetais");
			frangoLegumesLowCarb.setTempoDePreparo(40);
			frangoLegumesLowCarb.setObservacao("Sirva quente e aproveite! Temperar a gosto.");

			List<EtapaPreparo> etapasFrangoLegumesLowCarb = new ArrayList<>();
			etapasFrangoLegumesLowCarb.add(prepararFrango);
			etapasFrangoLegumesLowCarb.add(prepararLegumes);
			etapasFrangoLegumesLowCarb.add(assar);

			frangoLegumesLowCarb.setEtapasPreparo(etapasFrangoLegumesLowCarb);


			// Lista ingredientes - Frango legumes low carb 
			List<Ingrediente> ingredientesFrangoLegumesLowCarb = new ArrayList<>();
			ingredientesFrangoLegumesLowCarb.add(peitoFrango);
			ingredientesFrangoLegumesLowCarb.add(brócolis);
			ingredientesFrangoLegumesLowCarb.add(abobrinha);
			ingredientesFrangoLegumesLowCarb.add(cebola);
			ingredientesFrangoLegumesLowCarb.add(azeite);
			ingredientesFrangoLegumesLowCarb.add(alho);
			ingredientesFrangoLegumesLowCarb.add(sal);
			ingredientesFrangoLegumesLowCarb.add(pimenta);

			frangoLegumesLowCarb.setIngredientes(ingredientesFrangoLegumesLowCarb);
			frangoLegumesLowCarb.setObservacao("Tempere a gosto.");


			// Savar - Frango legumes low carb 
			rp.save(frangoLegumesLowCarb);


			// Curry Vegano
			Ingrediente graoDeBico = new Ingrediente();
			peitoFrango.setNome("Grão de Bico");
			peitoFrango.setUnidadeMedida("Pacote");
			peitoFrango.setQuantidade(1);

			Ingrediente curryEmPo = new Ingrediente();
			curryEmPo.setNome("Curry em Pó");
			curryEmPo.setUnidadeMedida("Colher de chá");
			curryEmPo.setQuantidade(2);

			Ingrediente leiteDeCoco = new Ingrediente();
			leiteDeCoco.setNome("Leite de Coco");
			leiteDeCoco.setUnidadeMedida("ml");
			leiteDeCoco.setQuantidade(200);

			Ingrediente pimentao = new Ingrediente();
			pimentao.setNome("Pimentão");
			pimentao.setUnidadeMedida("unidade");
			pimentao.setQuantidade(1);


			// Etapa de preparo - Curry vegano
			EtapaPreparo preparoGraoDeBico = new EtapaPreparo();
			preparoGraoDeBico.setDescricao("Deixe o grão-de-bico de molho por 8 horas, depois cozinhe até ficar macio\"");
			EtapaPreparo adicionarTomatePimentao = new EtapaPreparo();
			adicionarTomatePimentao.setDescricao("Adicione o tomate e o pimentão e refogue até amolecer");
			EtapaPreparo adicionarGraoDeBico = new EtapaPreparo();
			adicionarGraoDeBico.setDescricao("Adicione o grão-de-bico cozido e misture bem");
			EtapaPreparo adicionarLeiteDeCoco = new EtapaPreparo();
			adicionarLeiteDeCoco.setDescricao("Adicione o leite de coco e deixe cozinhar por mais alguns minutos até engrossar");

			Receita curryVegano = new Receita();
			curryVegano.setNome("Curry Vegano de Grão-de-Bico");
			curryVegano.setCategoria(CategoriaEnum.VEGANO);
			curryVegano.setDificuldade(DificuldadeEnum.FACIL);
			curryVegano.setRendimento("4 porções");
			curryVegano.setAutor("Fujiro Kamya Moto");
			curryVegano.setDescricao("Um curry vegano delicioso e nutritivo, perfeito para uma refeição reconfortante.");
			curryVegano.setTempoDePreparo(40);
			curryVegano.setObservacao("Sirva com arroz basmati ou pão naan. Tempere a gosto.");

			List<EtapaPreparo> etapasVegano = Arrays.asList(preparoGraoDeBico, refogarCebolaAlho,
					adicionarTomatePimentao, temperar, adicionarGraoDeBico, adicionarLeiteDeCoco);
			curryVegano.setEtapasPreparo(etapasVegano);

			List<Ingrediente> ingredientesVegano = Arrays.asList(graoDeBico, cebola, alho, tomate, curryEmPo, sal, pimenta, azeite, leiteDeCoco, pimentao);
			curryVegano.setIngredientes(ingredientesVegano);


			// Salvar - Curry vegano
			rp.save(curryVegano);

		};

	}

}
