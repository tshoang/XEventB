/*
 * generated by Xtext 2.17.1
 */
package ac.soton.xeventb.xmachine.serializer;

import ac.soton.eventb.emf.containment.Containment;
import ac.soton.eventb.emf.containment.ContainmentPackage;
import ac.soton.eventb.emf.inclusion.EventSynchronisation;
import ac.soton.eventb.emf.inclusion.InclusionPackage;
import ac.soton.eventb.emf.inclusion.MachineInclusion;
import ac.soton.xeventb.xmachine.services.XMachineGrammarAccess;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Invariant;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;
import org.eventb.emf.core.machine.Variant;
import org.eventb.emf.core.machine.Witness;

@SuppressWarnings("all")
public class XMachineSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private XMachineGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ContainmentPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ContainmentPackage.CONTAINMENT:
				sequence_MContains(context, (Containment) semanticObject); 
				return; 
			}
		else if (epackage == InclusionPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case InclusionPackage.EVENT_SYNCHRONISATION:
				sequence_EventSync(context, (EventSynchronisation) semanticObject); 
				return; 
			case InclusionPackage.MACHINE_INCLUSION:
				sequence_MIncludes(context, (MachineInclusion) semanticObject); 
				return; 
			}
		else if (epackage == MachinePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MachinePackage.ACTION:
				sequence_XAction(context, (org.eventb.emf.core.machine.Action) semanticObject); 
				return; 
			case MachinePackage.EVENT:
				sequence_XEvent(context, (Event) semanticObject); 
				return; 
			case MachinePackage.GUARD:
				sequence_XGuard(context, (Guard) semanticObject); 
				return; 
			case MachinePackage.INVARIANT:
				sequence_XInvariant(context, (Invariant) semanticObject); 
				return; 
			case MachinePackage.MACHINE:
				sequence_Machine(context, (Machine) semanticObject); 
				return; 
			case MachinePackage.PARAMETER:
				sequence_XParameter(context, (org.eventb.emf.core.machine.Parameter) semanticObject); 
				return; 
			case MachinePackage.VARIABLE:
				sequence_XVariable(context, (Variable) semanticObject); 
				return; 
			case MachinePackage.VARIANT:
				sequence_XVariant(context, (Variant) semanticObject); 
				return; 
			case MachinePackage.WITNESS:
				sequence_XWitness(context, (Witness) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     EventSync returns EventSynchronisation
	 *
	 * Constraint:
	 *     (prefix=ID? synchronisedEvent=[Event|ID])
	 */
	protected void sequence_EventSync(ISerializationContext context, EventSynchronisation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     MContains returns Containment
	 *
	 * Constraint:
	 *     (name=ID extension=[Diagram|QualifiedName])
	 */
	protected void sequence_MContains(ISerializationContext context, Containment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ContainmentPackage.Literals.CONTAINMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContainmentPackage.Literals.CONTAINMENT__NAME));
			if (transientValues.isValueTransient(semanticObject, ContainmentPackage.Literals.CONTAINMENT__EXTENSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ContainmentPackage.Literals.CONTAINMENT__EXTENSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMContainsAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getMContainsAccess().getExtensionDiagramQualifiedNameParserRuleCall_3_0_1(), semanticObject.eGet(ContainmentPackage.Literals.CONTAINMENT__EXTENSION, false));
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     MIncludes returns MachineInclusion
	 *
	 * Constraint:
	 *     (abstractMachine=[Machine|QualifiedName] concreteMachine=[Machine|ID]? (prefixes+=ID prefixes+=ID*)?)
	 */
	protected void sequence_MIncludes(ISerializationContext context, MachineInclusion semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Machine returns Machine
	 *
	 * Constraint:
	 *     (
	 *         (comment=ML_COMMENT | comment=SL_COMMENT)? 
	 *         name=ID 
	 *         (extensions+=MIncludes | refines+=[Machine|ID] | sees+=[Context|ID])* 
	 *         extensions+=MContains* 
	 *         variables+=XVariable* 
	 *         invariants+=XInvariant* 
	 *         variants+=XVariant* 
	 *         events+=XEvent*
	 *     )
	 */
	protected void sequence_Machine(ISerializationContext context, Machine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XAction returns Action
	 *
	 * Constraint:
	 *     (name=XLABEL action=XFormula)
	 */
	protected void sequence_XAction(ISerializationContext context, org.eventb.emf.core.machine.Action semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME));
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BACTION__ACTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BACTION__ACTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXActionAccess().getNameXLABELTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXActionAccess().getActionXFormulaParserRuleCall_2_0(), semanticObject.getAction());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XEvent returns Event
	 *
	 * Constraint:
	 *     (
	 *         convergence=XConvergence? 
	 *         name=ID 
	 *         (refines+=[Event|ID]+ | (extended?='extends' refines+=[Event|ID]))? 
	 *         parameters+=XParameter* 
	 *         extensions+=EventSync* 
	 *         guards+=XGuard* 
	 *         actions+=XAction* 
	 *         witnesses+=XWitness*
	 *     )
	 */
	protected void sequence_XEvent(ISerializationContext context, Event semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XGuard returns Guard
	 *
	 * Constraint:
	 *     (theorem?='theorem'? name=XLABEL predicate=XFormula)
	 */
	protected void sequence_XGuard(ISerializationContext context, Guard semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XInvariant returns Invariant
	 *
	 * Constraint:
	 *     (theorem?='theorem'? name=XLABEL predicate=XFormula)
	 */
	protected void sequence_XInvariant(ISerializationContext context, Invariant semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     XParameter returns Parameter
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_XParameter(ISerializationContext context, org.eventb.emf.core.machine.Parameter semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXParameterAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XVariable returns Variable
	 *
	 * Constraint:
	 *     name=ID
	 */
	protected void sequence_XVariable(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXVariableAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XVariant returns Variant
	 *
	 * Constraint:
	 *     (name=XLABEL expression=XFormula)
	 */
	protected void sequence_XVariant(ISerializationContext context, Variant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME));
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BEXPRESSION__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BEXPRESSION__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXVariantAccess().getNameXLABELTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXVariantAccess().getExpressionXFormulaParserRuleCall_2_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     XWitness returns Witness
	 *
	 * Constraint:
	 *     (name=XLABEL predicate=XFormula)
	 */
	protected void sequence_XWitness(ISerializationContext context, Witness semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BNAMED__NAME));
			if (transientValues.isValueTransient(semanticObject, CorePackage.Literals.EVENT_BPREDICATE__PREDICATE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, CorePackage.Literals.EVENT_BPREDICATE__PREDICATE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXWitnessAccess().getNameXLABELTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getXWitnessAccess().getPredicateXFormulaParserRuleCall_2_0(), semanticObject.getPredicate());
		feeder.finish();
	}
	
	
}
