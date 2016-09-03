import React from 'react';
import {Link} from 'react-router';

import CardActionCreators from '../flux/actions/CardActionCreators';
import CardStore from '../flux/stores/CardStore';
import CheckList from './CheckList.jsx';

class Card extends React.Component {
    toggleDetails() {
        CardActionCreators.toggleCardDetails(this.props.id);
    }
    
    render() {
        return(
            <div id={this.props.id} className="card">
                <div className="card_edit">
                    <Link to={'/edit/'+this.props.id}><span className="fa fa-pencil"></span></Link>
                    {"  "}
                    <a href="#" className="card_remove" 
					   onClick={CardActionCreators.deleteCard.bind(
					   				null,
					   				CardStore.getCard(this.props.id)
					   		   )}
					/>
                </div>
                <div 
                    className={(this.props.showDetails === undefined ||  this.props.showDetails) ?
                        'card_title_is_open':
                        'card_title'}
                    onClick={this.toggleDetails.bind(this)}
                >
                    {this.props.title}
                </div>
                {
                    (this.props.showDetails === undefined ||  this.props.showDetails) ? 
                    <div className="card_details">
                        <div dangerouslySetInnerHTML={{__html:this.props.description}}></div>
                        <CheckList cardId={this.props.id}
                                    tasks={this.props.tasks}
                        />
                    </div>
                    : <div></div>
                }
            </div>
        )
    }
}

export default Card;