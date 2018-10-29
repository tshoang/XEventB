/**
 * Copyright (c) 2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     University of Southampton - initial API and implementation
 */
package ac.soton.xeventb.internal.camillex.ui.navigator;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eventb.core.IEventBProject;
import org.eventb.core.IMachineRoot;
import org.rodinp.core.IInternalElement;

/**
 * A specific sub-class for context root content provider. This provide
 * the child of a XContext in the navigator.
 * 
 * @author dd4g12
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("all")
public final class EventBRootContentProvider implements /* AbstractRootContentProvider */ITreeContentProvider {
  /**
   * Returns the root element given the Event-B project and the name
   * of the element.
   * 
   * @param project
   *          The input Event-B project.
   * @param name
   *          The name of the root element.
   * @return the root element corresponding to the input project and
   *          name.
   */
  public abstract IInternalElement getRoot(final IEventBProject project, final String name);
  
  /**
   * Returns the Event-B root element corresponding to the XEvent-B
   * navigator object
   * 
   * @param parentElement
   *          The input parent element
   * @return The array containing the root element corresponding to
   *          the input parent element.
   */
  @Override
  public Object[] getChildren(final Object parentElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nIXEventBNavigatorObject cannot be resolved to a type."
      + "\nThe method or field resource is undefined for the type Object");
  }
  
  /**
   * Returns the children of the input element.
   * 
   * @param The input element
   * 
   * @return the children of the input element.
   */
  @Override
  public Object[] getElements(final Object inputElement) {
    return this.getChildren(inputElement);
  }
  
  /**
   * Returns the containing project of the input element.
   * 
   * @param element
   *          The input element.
   * @return the containing project of the input element.
   */
  @Override
  public Object getParent(final Object element) {
    if ((element instanceof IMachineRoot)) {
      return ((IMachineRoot)element).getResource().getProject();
    }
    return null;
  }
  
  /**
   * Returns if the input element has some children.
   * 
   * @return <code>true</code> if the input element has some children.
   */
  @Override
  public boolean hasChildren(final Object element) {
    int _length = this.getChildren(element).length;
    return (_length != 0);
  }
}
