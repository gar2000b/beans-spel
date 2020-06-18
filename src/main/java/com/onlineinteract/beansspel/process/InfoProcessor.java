package com.onlineinteract.beansspel.process;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Component;

@Component
public class InfoProcessor {

	private static final String ENTITLEMENTS_1_IMPORTANT = "@rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14 && "
			+ "@rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14 && "
			+ "@rock.volume == 14 && @rock.volume == 14 && @rock.volume == 14";

	@Autowired
	private BeanFactory beanFactory;

	public InfoProcessor() {
	}

	public void process() {
		System.err.println("**** process() invoked ****");
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression(ENTITLEMENTS_1_IMPORTANT);
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setBeanResolver(new BeanFactoryResolver(this.beanFactory));
		Boolean message = (Boolean) exp.getValue(context);
		System.out.println("Expression is: " + message);
	}
}
