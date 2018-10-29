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
package ac.soton.xeventb.internal.xcontext.ui.navigator;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eventb.core.IContextRoot;
import org.eventb.core.IEventBProject;

/**
 * A specific sub-class for context root content provider. This provide
 * the child of a XContext in the navigator.
 * 
 * @author dd4g12
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("all")
public final class ContextRootContentProvider implements /* AbstractRootContentProvider */ITreeContentProvider {
  @Override
  public IContextRoot getRoot(final IEventBProject project, final String name) {
    return project.getContextRoot(name);
  }
}
